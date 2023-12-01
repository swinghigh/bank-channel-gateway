package com.jkf.channel.gateway.handler;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;
import com.jkf.channel.gateway.constant.OrderTypeEnum;
import com.jkf.channel.gateway.entity.OrderInfo;
import com.jkf.channel.gateway.entity.OrderNotifyLog;
import com.jkf.channel.gateway.entity.OrgInfo;
import com.jkf.channel.gateway.entity.OrgInterfceKey;
import com.jkf.channel.gateway.service.*;
import com.jkf.channel.gateway.utils.HttpUtil;
import com.jkf.channel.gateway.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class NotifyService {
    private static String SUCCES="success";
    private static String FAIL="fail";
    @Autowired
    private OrgInfoService orgInfoService;
    @Autowired
    private OrgInterfceKeyService orgInterfceKeyService;

    @Autowired
    private ChannelMchtXlService channelMchtXlService;
    @Autowired
    private MchInfoService mchInfoService;
    @Resource
    private OrderNotifyLogService orderNotifyLogService;
    @Autowired
    private OrderInfoService orderInfoService;

    @Resource(name = "notifyExecutor")
    private Executor notifyExecutor;

    /**
     * 通知到业务系统
     * 不用事务，业务方做    重复通知幂等处理
     */
    public void noticeOrderNotifyLog(){
        List<OrderNotifyLog> orderNotifyLogList = orderNotifyLogService.selectNeedNoticeList();
        if (CollUtil.isNotEmpty(orderNotifyLogList)){
            log.info("待通知数量：{}", orderNotifyLogList.size());
            for (OrderNotifyLog orderNotifyLog : orderNotifyLogList) {
                notifyExecutor.execute(() -> {
                    try {
                        //具体的通知业务
                        String serial = orderNotifyLog.getSerial();
                        OrderInfo orderInfo = orderInfoService.selectBySerial(serial);
                        String orderType = orderInfo.getOrderType();
                        Map<String,Object> map=new HashMap<>();
                        if (OrderTypeEnum.PAY.getCode().equals(orderType)){
                            //交易订单
                            map.put("orderType",OrderTypeEnum.PAY.getCode());
                            //外部商户号，业务方的商户号
                            map.put("outMchId",orderInfo.getOutMchId());

                            //oriOrderId 外部订单号
                            map.put("oriOrderId",orderInfo.getOutSerial());

                            //本系统 产品类型:A支付宝,W微信,U银联
                            map.put("product",orderInfo.getProduct());
                            //本系统 子产品类型:
                            // W01-微信扫码支付W02-微信公众号支付W03-微信刷卡（反扫）W04-微信H5支付W05-微信APP支付W06-微信小程序
                            // A01-支付宝扫码支付A02-支付宝刷卡支付A03-支付窗支付A04-支付宝APP支付
                            // U01-银联二维码扫码支付
                            map.put("subProduct",orderInfo.getSubProduct());

                            //交易金额 单位分 orderAmount
                            map.put("orderAmount",orderInfo.getOrderAmount());
                            // 交易日期 交易成功时有值 格式yyyyMMdd
                            map.put("orderDate",orderInfo.getOrderDate());
                            // 交易结果描述   非必须
                            map.put("messageDesc",orderInfo.getRemark());

                        }else if (OrderTypeEnum.REFUND.getCode().equals(orderType)){
                            //退款订单
                            map.put("orderType",OrderTypeEnum.REFUND.getCode());
                            //外部商户号，业务方的商户号
                            map.put("outMchId",orderInfo.getOutMchId());

                            //商户退款订单号
                            map.put("orderId",orderInfo.getOutSerial());
                            // 交易金额 单位分
                            map.put("refundAmount",orderInfo.getOrderAmount());
                            // 交易日期 交易成功时有值 格式yyyyMMdd
                            map.put("refundSuccTime",orderInfo.getOrderDate());
                            // 交易结果描述   非必须
                            map.put("messageDesc",orderInfo.getRemark());

                        }else {
                            return;
                        }
                        OrderNotifyLog updateEntity=new OrderNotifyLog();
                        updateEntity.setRetryTime(new Date());
                        updateEntity.setRetryFlag("1");

                        Long orgId = orderNotifyLog.getOrgId();
                        OrgInfo orgInfo = orgInfoService.selectByPrimaryKey(orgId);
                        OrgInterfceKey orgInterfceKey = orgInterfceKeyService.getFromCache(orgInfo.getOrgNo());
                        //平台私钥
                        String platPrivateKey = orgInterfceKey.getPlatPrivateKey();
                        //业务方机构的公钥， 平台用来加密数据
                        String orgPublicKey = orgInterfceKey.getOrgPublicKey();

                        //发送通知
                        Map<String, Object> result = new HashMap<>();
                        result.put(KeyConstants.CODE, ErrorCode.SUCCESS.getErrorCode());
                        result.put(KeyConstants.MSG, "操作成功");
                        //使用机构的公钥加密
                        JSONObject respJson = new JSONObject(map);
                        result.put("respData", RSAUtil.publicEncrypt(respJson.toJSONString(), orgPublicKey));
                        //加签,平台的私钥生成签名
                        result.put("sign", RSAUtil.sign(result, platPrivateKey));
                        //请求业务方
                        String response = HttpUtil.sendPost(orderNotifyLog.getNotifyUrl(), result.toString());
                        log.info("response:{}",response);
                        boolean dealSucces=false;
                        if (StringUtils.isNotEmpty(response)) {
                            //还需要判断是否是处理成功
                            if (SUCCES.equalsIgnoreCase(response)){
                                //通知成功
                                dealSucces=true;
                            }
                        }

                        updateEntity.setId(orderNotifyLog.getId());
                        if (dealSucces){
                            //通知成功
                            updateEntity.setNotifyStatus("1");
                            updateEntity.setUpdateTime(new Date());
                        }else {
                            Integer notifyCount = orderNotifyLog.getNotifyCount();
                            updateEntity.setNotifyCount(notifyCount+1);
                            if (notifyCount >= 9){
                                //之前已经通知了9次，这次还是失败，因此 通知失败
                                updateEntity.setNotifyStatus("2");
                            }else {
                                //置为 未通知，下次任务再查
                                updateEntity.setNotifyStatus("0");
                            }
                            updateEntity.setUpdateTime(new Date());
                        }
                        orderNotifyLogService.updateByPrimaryKeySelective(updateEntity);
                    } catch (Exception e) {
                        log.error("noticeOrderNotifyLog发生异常,Exception",e);
                    }
                });

            }

        }

    }



}
