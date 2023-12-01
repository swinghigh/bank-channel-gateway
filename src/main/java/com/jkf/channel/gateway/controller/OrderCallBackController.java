package com.jkf.channel.gateway.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.service.*;
import com.jkf.channel.gateway.utils.xinwang.XinWangSignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * 处理通道直接推送订单的接口
 *
 * @author xiangyu
 * @date 2023/10/30 15:34
 */
@Slf4j
@RestController
@RequestMapping("/callback")
public class OrderCallBackController {
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
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderNotifyLogService orderNotifyLogService;

    /**
     * 支付结果通知
     * {
     * "signType": "SM2",
     * "bizType": "PayNotify-支付通知",
     * "trxCtgy": "13",
     * "partnerId": "商户编号",
     * "oriOrderId": "原商户订单号",
     * "trxAmt": "1000",
     * "trxStatus": "90",
     * "settlemtDt": "20231201",
     * "oriTrxDtTm": "20231201023827",
     * "messageDesc": "交易成功",
     * "signature": "签名值"
     * }
     *
     * @param params
     * @return
     */
    @RequestMapping("/pay")
    public Object pay(@RequestBody Map<String, Object> params) {
        log.info("信联支付结果通知参数：{}", params);
        try {
            /*------ start:验签 ------*/
            //  拼接响应参数字符串
            cn.hutool.json.JSONObject bussRespDataObj = JSONUtil.parseObj(params);
            String resObj = XinWangSignUtil.buildParamStr(bussRespDataObj);
            //  获取签名字段
            String respSignature = bussRespDataObj.getStr(XinWangSignUtil.SIGN_PROPERTY);
            //  验签
            boolean resVerify = XinWangSignUtil.cfcaVerify(resObj, respSignature);
            log.info("验签结果：{}", resVerify);
            /*-------- end:验签 -------*/

            String signType = bussRespDataObj.getStr("signType");
            //业务类型，PayNotify-支付通知
            String bizType = bussRespDataObj.getStr("bizType");
            //交易类别13-微信用户被扫，15-微信用户主扫，22-支付宝用户主扫，23-支付宝被扫，53-银联用户主扫
            String trxCtgy = bussRespDataObj.getStr("trxCtgy");
            //进件的时候是服务商编号 这里是商户号 通过此商户号查相关信息
            //商户编号信联支付给合作商户分配的唯一标识
            String partnerId = bussRespDataObj.getStr("partnerId");
            //原商户订单号 我们系统的订单id
            String oriOrderId = bussRespDataObj.getStr("oriOrderId");
            String trxAmt = bussRespDataObj.getStr("trxAmt");
            //交易状态 70:交易失败，90:交易成功
            String trxStatus = bussRespDataObj.getStr("trxStatus");
            //清算时间，交易成功时有值，格式 yyyyMMdd
            String settlemtDt = bussRespDataObj.getStr("settlemtDt");
            //交易时间，交易成功时有值 ， 格式 yyyyMMddHHmmss
            String oriTrxDtTm = bussRespDataObj.getStr("oriTrxDtTm");
            //交易结果描述
            String messageDesc = bussRespDataObj.getStr("messageDesc");

            //查商户信息
            ChannelMchtXl channelMchtXl = channelMchtXlService.getByChannelMchtNo(partnerId);
            if (channelMchtXl == null) {
                log.info("商户信息不存在,商户号partnerId：{}", partnerId);
                return SUCCES;
            }

            Long mchId = channelMchtXl.getMchId();
            MchInfo mchInfo = mchInfoService.selectByPrimaryKey(mchId);
            //重复通知
            OrderInfo oriOrderInfo = orderInfoService.selectByOutSerial(oriOrderId);
            if (ObjectUtil.isEmpty(oriOrderInfo)){
                log.info("已处理outSerial：{}",oriOrderId);
                return SUCCES;
            }

            OrderInfo orderInfo = new OrderInfo();
//        orderInfo.setId(1234L); //自动递增
            //系统订单号(订单唯一标识) 32位
            String uuid = UUID.randomUUID().toString().replace("-", "");
            orderInfo.setSerial(uuid);
            //系统外部单号 == 服务商或代理
            orderInfo.setOutSerial(oriOrderId);
            //外部商户号 == 服务商或代理
            orderInfo.setOutMchId(mchInfo.getOutMchNo());
            //系统商户号
            orderInfo.setMchId(mchInfo.getId());
            //商户所属机构
            orderInfo.setOrgId(mchInfo.getOrgId());
            //交易产生应用编号(这个可能用于订单推送到其他的系统使用)org_id与trade_org_id可能会不一致,只要标识订单产生来源
            if (mchInfo.getOrgId() != null) {
                orderInfo.setOrgAppNo(mchInfo.getOrgId().toString());
            }
            //商户直属代理商
            orderInfo.setAgentId(mchInfo.getAgentId());
            //商户名称(冗余)
            orderInfo.setMchName(mchInfo.getMchName());
            orderInfo.setChannelId(channelMchtXl.getChannelId());
            orderInfo.setChannelMchNo(channelMchtXl.getChannelMchtNo());
//        //退款订单的原系统单号
//        orderInfo.setOrigSerial("ORIGSERIAL456");
            //订单类型 1交易订单 2退款订单3预授权4分账订单
            orderInfo.setOrderType("1");
            //信联 交易类别13-微信用户被扫，15-微信用户主扫，22-支付宝用户主扫，23-支付宝被扫，53-银联用户主扫
            if ("13".equals(trxCtgy)) {
                //本系统 产品类型:A支付宝 W微信U银联C刷卡B银行卡在线支付
                orderInfo.setProduct("W");
                //本系统 子产品类型: W01-微信扫码支付W02-微信公众号支付W03-微信刷卡（反扫）W04-微信H5支付W05-微信APP支付W06-微信小程序A01-支付宝扫码支付A02-支付宝刷卡支付A03-支付窗支付A04-支付宝APP支付U01-银联二维码扫码支付U03-银联二维码被扫U05-银联云闪付(ApplePay)U06-银联行业码
                orderInfo.setSubProduct("W03");
            } else if ("15".equals(trxCtgy)) {
                orderInfo.setProduct("W");
                orderInfo.setSubProduct("W01");
            } else if ("22".equals(trxCtgy)) {
                orderInfo.setProduct("A");
                orderInfo.setSubProduct("A01");
            } else if ("23".equals(trxCtgy)) {
                orderInfo.setProduct("A");
                orderInfo.setSubProduct("A02");
            } else if ("53".equals(trxCtgy)) {
                orderInfo.setProduct("U");
                orderInfo.setSubProduct("U03");
            }

            OrgInfo orgInfo = orgInfoService.selectByPrimaryKey(mchInfo.getOrgId());
            String orgNo = orgInfo.getOrgNo();
            OrgInterfceKey orgInterfceKey = orgInterfceKeyService.getFromCache(orgNo);
            String payNotifyUrl = orgInterfceKey.getPayNotifyUrl();
            //订单通知地址   配置
            orderInfo.setNotifyUrl(payNotifyUrl);
            //交易金额,分
            orderInfo.setOrderAmount(Long.parseLong(trxAmt));
            boolean tradeSuccess = false;
            //交易状态映射
            if ("70".equals(trxStatus)) {
                //本系统 交易状态-1 聚合码未扫码 0：未支付/处理中  1 成功 2 失败 3 申请退款 4退款成功（全部） 5退款失败 6交易关闭 7退款成功（部分）
                //交易失败 不通知
                orderInfo.setTradeStatus("2");
            } else if ("90".equals(trxStatus)) {
                //订单日期yyyyMMdd 交易时间截取前8位
                orderInfo.setOrderDate(oriTrxDtTm.substring(0, 9));
                //订单完成时间  未传入 这里存 传入的清算时间的yyMMdd
                orderInfo.setFinishTime(settlemtDt);
                orderInfo.setTradeStatus("1");
                tradeSuccess = true;
            }

//        orderInfo.setRefundStatus("");
            orderInfo.setRemark(messageDesc);
            //订单来源 api 接口 notify 推送
            orderInfo.setOrderSource("notify");
            Date now = new Date();
            orderInfo.setCreateTime(now);
            orderInfo.setUpdateTime(now);
            orderInfoService.insert(orderInfo);
            if (tradeSuccess) {
                //交易成功 需要新增通知表
                OrderNotifyLog orderNotifyLog = new OrderNotifyLog();
//            orderNotifyLog.setId(id);//自增
                //通知的订单号
                orderNotifyLog.setSerial(uuid);
                orderNotifyLog.setOrgId(mchInfo.getOrgId());
                orderNotifyLog.setNotifyUrl(payNotifyUrl);
                orderNotifyLog.setNotifyCount(0);
                //定时任务重试标识 0未重试1重试
                orderNotifyLog.setRetryFlag("0");
////            重试时间
//            orderNotifyLog.setRetryTime();
                //通知状态0未通知 1通知成功 2通知失败 3通知中
                orderNotifyLog.setNotifyStatus("0");
//            orderNotifyLog.setFailReason(failReason);
                orderNotifyLog.setCreateTime(now);
//            orderNotifyLog.setCreateId(createId);
                orderNotifyLog.setUpdateTime(now);
//            orderNotifyLog.setUpdateId(updateId);
                orderNotifyLogService.insert(orderNotifyLog);
            }
            return SUCCES;
        } catch (Exception e) {
            log.error("通知处理异常",e);
            return FAIL;
        }
    }


    /**
     * 退款结果通知
     * {
     *   "signType": "SM2",
     *   "bizType": "RefundNotify-退款结果通知",
     *   "partnerId": "商户编号",
     *   "orderId": "商户退款订单号",
     *   "refundAmount": "500",
     *   "orderStatus": "90",
     *   "refundSuccTime": "20231201093045",
     *   "messageDesc": "退款成功",
     *   "signature": "签名值"
     * }
     */
    @RequestMapping("/refund")
    public Object refund(@RequestBody Map<String, Object> params) {
        log.info("信联退款结果通知参数：{}", params);
        try {
            /*------ start:验签 ------*/
            //  拼接响应参数字符串
            cn.hutool.json.JSONObject bussRespDataObj = JSONUtil.parseObj(params);
            String resObj = XinWangSignUtil.buildParamStr(bussRespDataObj);
            //  获取签名字段
            String respSignature = bussRespDataObj.getStr(XinWangSignUtil.SIGN_PROPERTY);
            //  验签
            boolean resVerify = XinWangSignUtil.cfcaVerify(resObj, respSignature);
            log.info("验签结果：{}", resVerify);
            /*-------- end:验签 -------*/

            String signType = bussRespDataObj.getStr("signType");
            //业务类型，RefundNotify-退款结果通知
            String bizType = bussRespDataObj.getStr("bizType");
            //进件的时候是服务商编号 这里是商户号 通过此商户号查相关信息
            //商户编号信联支付给合作商户分配的唯一标识
            String partnerId = bussRespDataObj.getStr("partnerId");
            //商户退款订单号
            String orderId = bussRespDataObj.getStr("orderId");
            String refundAmount = bussRespDataObj.getStr("refundAmount");
            //交易状态 70:交易失败，90:交易成功
            String trxStatus = bussRespDataObj.getStr("trxStatus");

            //交易成功时间，交易成功时有值，格式yyyyMMddHHmmss
            String refundSuccTime = bussRespDataObj.getStr("refundSuccTime");
            //交易结果描述
            String messageDesc = bussRespDataObj.getStr("messageDesc");

            //查商户信息
            ChannelMchtXl channelMchtXl = channelMchtXlService.getByChannelMchtNo(partnerId);
            if (channelMchtXl == null) {
                log.info("商户信息不存在,商户号partnerId：{}", partnerId);
                return SUCCES;
            }
            //重复通知
            OrderInfo oriOrderInfo = orderInfoService.selectByOutSerial(orderId);
            if (ObjectUtil.isEmpty(oriOrderInfo)){
                log.info("已处理outSerial：{}",orderId);
                return SUCCES;
            }

            Long mchId = channelMchtXl.getMchId();
            MchInfo mchInfo = mchInfoService.selectByPrimaryKey(mchId);

            OrderInfo orderInfo = new OrderInfo();
//        orderInfo.setId(1234L); //自动递增
            //系统订单号(订单唯一标识) 32位
            String uuid = UUID.randomUUID().toString().replace("-", "");
            orderInfo.setSerial(uuid);
            //系统外部单号 == 服务商或代理
            orderInfo.setOutSerial(orderId);
            //外部商户号 == 服务商或代理
            orderInfo.setOutMchId(mchInfo.getOutMchNo());
            //系统商户号
            orderInfo.setMchId(mchInfo.getId());
            //商户所属机构
            orderInfo.setOrgId(mchInfo.getOrgId());
            //交易产生应用编号(这个可能用于订单推送到其他的系统使用)org_id与trade_org_id可能会不一致,只要标识订单产生来源
            if (mchInfo.getOrgId() != null) {
                orderInfo.setOrgAppNo(mchInfo.getOrgId().toString());
            }
            //商户直属代理商
            orderInfo.setAgentId(mchInfo.getAgentId());
            //商户名称(冗余)
            orderInfo.setMchName(mchInfo.getMchName());
            orderInfo.setChannelId(channelMchtXl.getChannelId());
            orderInfo.setChannelMchNo(channelMchtXl.getChannelMchtNo());
            //退款订单的原系统单号
            orderInfo.setOrigSerial(orderId);
            //订单类型 1交易订单 2退款订单3预授权4分账订单
            orderInfo.setOrderType("2");

            OrgInfo orgInfo = orgInfoService.selectByPrimaryKey(mchInfo.getOrgId());
            String orgNo = orgInfo.getOrgNo();
            OrgInterfceKey orgInterfceKey = orgInterfceKeyService.getFromCache(orgNo);
            String payNotifyUrl = orgInterfceKey.getPayNotifyUrl();
            //订单通知地址   配置
            orderInfo.setNotifyUrl(payNotifyUrl);
            //交易金额,分
            orderInfo.setOrderAmount(Long.parseLong(refundAmount));
            boolean tradeSuccess = false;
            //交易状态映射   交易状态 70:交易失败，90:交易成功
            if ("70".equals(trxStatus)) {
                //本系统 交易状态-1 聚合码未扫码 0：未支付/处理中  1 成功 2 失败 3 申请退款 4退款成功（全部） 5退款失败 6交易关闭 7退款成功（部分）
                //交易失败 不通知
                orderInfo.setTradeStatus("2");
            } else if ("90".equals(trxStatus)) {
                //订单日期yyyyMMdd 交易时间截取前8位
                orderInfo.setOrderDate(refundSuccTime.substring(0, 9));
                orderInfo.setTradeStatus("1");
                tradeSuccess = true;
            }
            //退款状态:0未发起 1部分退款成功 2全额退款成功
            orderInfo.setRefundStatus("2");
            orderInfo.setRemark(messageDesc);
            //订单来源 api 接口 notify 推送
            orderInfo.setOrderSource("notify");
            Date now = new Date();
            orderInfo.setCreateTime(now);
            orderInfo.setUpdateTime(now);
            orderInfoService.insert(orderInfo);
            if (tradeSuccess) {
                //交易成功 需要新增通知表
                OrderNotifyLog orderNotifyLog = new OrderNotifyLog();
//            orderNotifyLog.setId(id);//自增
                //通知的订单号
                orderNotifyLog.setSerial(uuid);
                orderNotifyLog.setOrgId(mchInfo.getOrgId());
                orderNotifyLog.setNotifyUrl(payNotifyUrl);
                orderNotifyLog.setNotifyCount(0);
                //定时任务重试标识 0未重试1重试
                orderNotifyLog.setRetryFlag("0");
////            重试时间
//            orderNotifyLog.setRetryTime();
                //通知状态0未通知 1通知成功 2通知失败 3通知中
                orderNotifyLog.setNotifyStatus("0");
//            orderNotifyLog.setFailReason(failReason);
                orderNotifyLog.setCreateTime(now);
//            orderNotifyLog.setCreateId(createId);
                orderNotifyLog.setUpdateTime(now);
//            orderNotifyLog.setUpdateId(updateId);
                orderNotifyLogService.insert(orderNotifyLog);
            }
            return SUCCES;
        } catch (Exception e) {
            log.error("通知处理异常",e);
            return FAIL;
        }
    }

}
