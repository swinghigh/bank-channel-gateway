package com.jkf.channel.gateway.channel.xinUnion;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.jkf.channel.gateway.constant.XlBizTypeNotifyEnum;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author xiangyu
 * @date 2023/12/5 14:12
 */
@Service
@Slf4j
public class XlBizPayNotifyHandler implements IXlBizNotifyHandler{
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

    @Override
    public String getBizType() {
        return XlBizTypeNotifyEnum.PayNotify.getBizType();
    }

    /**
     * {"oriTrxDtTm":"20231205150343","bizType":"PayNotify","settlemtDt":"20231205","signature":"MIID/wYKKoEcz1UGAQQCAqCCA+8wggPrAgEBMQ4wDAYIKoEcz1UBgxEFADARBgoqgRzPVQYBBAIBoAMEAWKgggLrMIIC5zCCAougAwIBAgIFEEgICCYwDAYIKoEcz1UBg3UFADBcMQswCQYDVQQGEwJDTjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRswGQYDVQQDDBJDRkNBIFRFU1QgU00yIE9DQTEwHhcNMjIwMjA4MDgwODQ0WhcNMjIwODA4MDgwODQ0WjCBizELMAkGA1UEBhMCQ04xDDAKBgNVBAoMA0JPQzETMBEGA1UECwwKQ0ZDQVRlY2hURTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjE+MDwGA1UEAww1Q0ZDQVRlY2hURUDkv6HogZTmlK/ku5jlm73lr4blj4zor4HmtYvor5VAWjExMTExMTExQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAR3CJx7gJheFkuIyrd9MkDU+fYXa2p/GX6+S3bwfzVR1T5NhpJzo9NKt0AjuGKUnJ5/2pMA6RqpvX79EiO2MQSoo4IBBjCCAQIwHwYDVR0jBBgwFoAUa/4Y2o9COqa4bbMuiIM6NKLBMOEwDAYDVR0TAQH/BAIwADBIBgNVHSAEQTA/MD0GCGCBHIbvKgEBMDEwLwYIKwYBBQUHAgEWI2h0dHA6Ly93d3cuY2ZjYS5jb20uY24vdXMvdXMtMTQuaHRtMDkGA1UdHwQyMDAwLqAsoCqGKGh0dHA6Ly91Y3JsLmNmY2EuY29tLmNuL1NNMi9jcmwyOTkxNS5jcmwwDgYDVR0PAQH/BAQDAgbAMB0GA1UdDgQWBBSZQYQ90WdD82Dt3CiE1anENsJQGjAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UFAANIADBFAiEArrWzDB2I+z6jHswZJx6z3q7cgavXs4aq1K2mu+fV3doCIFskV5SJho4H7r8ub32dOryrpX4UR30m1Ul8mkXTCXhvMYHTMIHQAgEBMGUwXDELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEbMBkGA1UEAwwSQ0ZDQSBURVNUIFNNMiBPQ0ExAgUQSAgIJjAMBggqgRzPVQGDEQUAMA0GCSqBHM9VAYItAQUABEcwRQIgUhsszWzBZA7ntVXnnUup87TypHRZkPtb6zQzORzUVggCIQDIxvFxCPA24xZusr0+jk8ldiu6kR6QHARzAhc4dPUPTQ==","trxStatus":"90","trxCtgy":"22","oriOrderId":"1701759798184000","messageDesc":"TRADE_SUCCESS","signType":"SM2","partnerId":"1656438344850440193","trxAmt":"10"}
     * @param bodyParam 通知的参数
     * @param orderId 商户申请id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void notifyHandler(String bodyParam, String orderId) {
        log.info("收到支付通知bodyParam:{}，合作伙伴申请单号orderId：{}",bodyParam,orderId);
        //  拼接响应参数字符串
        cn.hutool.json.JSONObject bussRespDataObj = JSONUtil.parseObj(bodyParam);
        String signType = bussRespDataObj.getStr("signType");
        //业务类型，PayNotify-支付通知
        String bizType = bussRespDataObj.getStr("bizType");
        //交易类别13-微信用户被扫，15-微信用户主扫，22-支付宝用户主扫，23-支付宝被扫，53-银联用户主扫
        String trxCtgy = bussRespDataObj.getStr("trxCtgy");
        //进件的时候是服务商编号 这里是商户号 通过此商户号查相关信息
        //商户编号信联支付给合作商户分配的唯一标识
        String partnerId = bussRespDataObj.getStr("partnerId");
        //原商户订单号 信联的订单号(我们系统对应channelOrderNo和outSerial)
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
            return;
        }

        Long mchId = channelMchtXl.getMchId();
        MchInfo mchInfo = mchInfoService.selectByPrimaryKey(mchId);
        //重复通知
        OrderInfo oriOrderInfo = orderInfoService.selectByChannelOrderNo(oriOrderId);
        if (ObjectUtil.isNotEmpty(oriOrderInfo)) {
            log.info("已处理channelOrderNo：{}", oriOrderId);
            return;
        }

        OrderInfo orderInfo = new OrderInfo();
//        orderInfo.setId(1234L); //自动递增
        //系统订单号(订单唯一标识) 32位
//        String uuid = UUID.randomUUID().toString().replace("-", "");
        String uuid =orderInfoService.getSerial();
        orderInfo.setSerial(uuid);
        //系统外部单号 == 服务商或代理  对接我们的商户请求我们的订单
        orderInfo.setOutSerial(oriOrderId);
        //信联的唯一订单号 我们请求别人（如信联）对应他们的唯一订单号
        orderInfo.setChannelOrderNo(oriOrderId);
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
        //交易卡类型   1：借记卡   2：贷记卡 0未知
        orderInfo.setCardType("0");

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
            orderInfo.setOrderDate(oriTrxDtTm.substring(0, 8));
            //订单完成时间  未传入 这里存 传入交易成功时间
            orderInfo.setFinishTime(oriTrxDtTm);
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
            orderNotifyLog.setRetryTime(new Date());
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
    }
}
