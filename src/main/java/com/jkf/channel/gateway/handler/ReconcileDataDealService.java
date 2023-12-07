package com.jkf.channel.gateway.handler;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.service.*;
import com.jkf.channel.gateway.vo.XlTradeInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 对账数据处理
 */
@Slf4j
@Service
public class ReconcileDataDealService {

    @Resource
    private OrderInfoService orderInfoService;
    @Autowired
    private OrgInfoService orgInfoService;

    @Autowired
    private ChannelMchtXlService channelMchtXlService;
    @Autowired
    private MchInfoService mchInfoService;
    @Resource
    private OrderNotifyLogService orderNotifyLogService;


    public void xlDealTradeInfo(XlTradeInfo tradeInfo, ChannelMchtXl channelMchtXl,MchInfo mchInfo,OrgInterfceKey orgInterfceKey){
        if("2001".equals(tradeInfo.getTransactionType())){
            //支付订单处理
            dealPayTradeInfo( tradeInfo,  channelMchtXl, mchInfo, orgInterfceKey);
        }else if("2002".equals(tradeInfo.getTransactionType())){
            //退款订单处理
            dealRefundTradeInfo( tradeInfo,  channelMchtXl, mchInfo, orgInterfceKey);
        }
    }

    /**
     * 处理 交易通知
     * @param tradeInfo
     * @param channelMchtXl
     * @param mchInfo
     * @param orgInterfceKey
     */
    private void dealPayTradeInfo(XlTradeInfo tradeInfo, ChannelMchtXl channelMchtXl,MchInfo mchInfo,OrgInterfceKey orgInterfceKey){
        String oriOrderId = tradeInfo.getOriOrderId();
        //手续费   转分
        long chargeAmt=0;
        if (StrUtil.isNotEmpty(tradeInfo.getChargeAmt())){
            double chargeAmtDouble = Double.parseDouble(tradeInfo.getChargeAmt());
            chargeAmt = (long) (chargeAmtDouble * 100);
        }
        //交易金额  转分
        double trxAmtDouble = Double.parseDouble(tradeInfo.getTrxAmt());
        long trxAmt = (long) (trxAmtDouble * 100);
        OrderInfo orderInfo = orderInfoService.selectByChannelOrderNo(oriOrderId);
        if (orderInfo != null){
            //订单类型 1交易订单 2退款订单3预授权4分账订单
            if (!orderInfo.getOrderType().equals("1")){
                //对账金额错误
                log.error("订单类型错误:outSerial:{}",oriOrderId);
                return;
            }
            if (orderInfo.getOrderAmount().compareTo(trxAmt)!=0){
                //对账金额错误
                log.error("对账金额错误:outSerial:{}",oriOrderId);
                return;
            }
            //更新
            OrderInfo updateOrderInfo=new OrderInfo();
            updateOrderInfo.setId(orderInfo.getId());
            updateOrderInfo.setOrderSource("api");
            //对账状态1已对账 0未对账
            updateOrderInfo.setBillStatus("1");
            updateOrderInfo.setChargeAmount(chargeAmt);
            updateOrderInfo.setUpdateTime(new Date());
            orderInfoService.updateByPrimaryKeySelective(updateOrderInfo);
        }else {
            //新增
            OrderInfo insertOrderInfo = new OrderInfo();
//        insertOrderInfo.setId(1234L); //自动递增
            //系统订单号(订单唯一标识) 32位
            String uuid = UUID.randomUUID().toString().replace("-", "");
            insertOrderInfo.setSerial(uuid);
            //系统外部单号 == 服务商或代理  对接我们的商户请求我们的订单
            insertOrderInfo.setOutSerial(oriOrderId);
            //信联的唯一订单号 我们请求别人（如信联）对应他们的唯一订单号
            insertOrderInfo.setChannelOrderNo(oriOrderId);
            //外部商户号 == 服务商或代理
            insertOrderInfo.setOutMchId(mchInfo.getOutMchNo());
            //系统商户号
            insertOrderInfo.setMchId(mchInfo.getId());
            //商户所属机构
            insertOrderInfo.setOrgId(mchInfo.getOrgId());
            //交易产生应用编号(这个可能用于订单推送到其他的系统使用)org_id与trade_org_id可能会不一致,只要标识订单产生来源
            if (mchInfo.getOrgId() != null) {
                insertOrderInfo.setOrgAppNo(mchInfo.getOrgId().toString());
            }
            //商户直属代理商
            insertOrderInfo.setAgentId(mchInfo.getAgentId());
            //商户名称(冗余)
            insertOrderInfo.setMchName(mchInfo.getMchName());
            insertOrderInfo.setChannelId(channelMchtXl.getChannelId());
            insertOrderInfo.setChannelMchNo(channelMchtXl.getChannelMchtNo());
            //订单类型 1交易订单 2退款订单3预授权4分账订单
            insertOrderInfo.setOrderType("1");
            String trxCtgy = tradeInfo.getTrxCtgy();
            String trxStatus = tradeInfo.getTrxStatus();
            //信联 交易类别13-微信用户被扫，15-微信用户主扫，22-支付宝用户主扫，23-支付宝被扫，53-银联用户主扫
            if ("13".equals(trxCtgy)) {
                //本系统 产品类型:A支付宝 W微信U银联C刷卡B银行卡在线支付
                insertOrderInfo.setProduct("W");
                //本系统 子产品类型: W01-微信扫码支付W02-微信公众号支付W03-微信刷卡（反扫）W04-微信H5支付W05-微信APP支付W06-微信小程序A01-支付宝扫码支付A02-支付宝刷卡支付A03-支付窗支付A04-支付宝APP支付U01-银联二维码扫码支付U03-银联二维码被扫U05-银联云闪付(ApplePay)U06-银联行业码
                insertOrderInfo.setSubProduct("W03");
            } else if ("15".equals(trxCtgy)) {
                insertOrderInfo.setProduct("W");
                insertOrderInfo.setSubProduct("W01");
            } else if ("22".equals(trxCtgy)) {
                insertOrderInfo.setProduct("A");
                insertOrderInfo.setSubProduct("A01");
            } else if ("23".equals(trxCtgy)) {
                insertOrderInfo.setProduct("A");
                insertOrderInfo.setSubProduct("A02");
            } else if ("53".equals(trxCtgy)) {
                insertOrderInfo.setProduct("U");
                insertOrderInfo.setSubProduct("U03");
            }
            //交易卡类型   1：借记卡   2：贷记卡 0未知
            insertOrderInfo.setCardType("0");

            String payNotifyUrl = orgInterfceKey.getPayNotifyUrl();
            //订单通知地址   配置
            insertOrderInfo.setNotifyUrl(payNotifyUrl);
            //交易金额,分
            insertOrderInfo.setOrderAmount(trxAmt);
            boolean tradeSuccess = false;
            //交易状态映射
            if ("70".equals(trxStatus)) {
                //本系统 交易状态-1 聚合码未扫码 0：未支付/处理中  1 成功 2 失败 3 申请退款 4退款成功（全部） 5退款失败 6交易关闭 7退款成功（部分）
                //交易失败 不通知
                insertOrderInfo.setTradeStatus("2");
            } else if ("90".equals(trxStatus)) {
                //订单日期yyyyMMdd 交易时间截取前8位
                insertOrderInfo.setOrderDate(tradeInfo.getTradeDate());
                //订单完成时间  未传入 这里存 传入交易成功时间
                insertOrderInfo.setFinishTime(tradeInfo.getTradeDate() + tradeInfo.getTradeTime());
                insertOrderInfo.setTradeStatus("1");
                tradeSuccess = true;
            }

            //订单来源 api 接口 notify 推送
            insertOrderInfo.setOrderSource("api");
            insertOrderInfo.setBillStatus("1");
            Date now = new Date();
            insertOrderInfo.setCreateTime(now);
            insertOrderInfo.setUpdateTime(now);

            orderInfoService.insert(insertOrderInfo);
            if (tradeSuccess) {
                //交易成功 需要新增通知表
                addOrderNotifyLog(uuid,mchInfo.getOrgId(),payNotifyUrl);
            }
        }
    }

    /**
     * 处理退款通知
     * @param tradeInfo
     * @param channelMchtXl
     * @param mchInfo
     * @param orgInterfceKey
     */
    private void dealRefundTradeInfo(XlTradeInfo tradeInfo, ChannelMchtXl channelMchtXl,MchInfo mchInfo,OrgInterfceKey orgInterfceKey){
        String oriOrderId = tradeInfo.getOriOrderId();
        String trxStatus = tradeInfo.getTrxStatus();
        //手续费   转分
        long chargeAmt=0;
        if (StrUtil.isNotEmpty(tradeInfo.getChargeAmt())){
            double chargeAmtDouble = Double.parseDouble(tradeInfo.getChargeAmt());
            chargeAmt = (long) (chargeAmtDouble * 100);
        }
        //交易金额  转分
        double trxAmtDouble = Double.parseDouble(tradeInfo.getTrxAmt());
        long trxAmt = (long) (trxAmtDouble * 100);
        OrderInfo orderInfo = orderInfoService.selectByChannelOrderNo(oriOrderId);
        if (orderInfo != null){
            //订单类型 1交易订单 2退款订单3预授权4分账订单
            if (!orderInfo.getOrderType().equals("2")){
                //对账金额错误
                log.error("订单类型错误:outSerial:{}",oriOrderId);
                return;
            }

            if (orderInfo.getOrderAmount().compareTo(trxAmt)!=0){
                //对账金额错误
                log.error("对账金额错误:outSerial:{}",oriOrderId);
                return;
            }

            //更新
            OrderInfo updateOrderInfo=new OrderInfo();
            updateOrderInfo.setId(orderInfo.getId());
            updateOrderInfo.setOrderSource("api");
            //对账状态1已对账 0未对账
            updateOrderInfo.setBillStatus("1");
            updateOrderInfo.setChargeAmount(chargeAmt);
            updateOrderInfo.setUpdateTime(new Date());
            orderInfoService.updateByPrimaryKeySelective(updateOrderInfo);
        }else {
            //新增
            OrderInfo insertOrderInfo = new OrderInfo();
//        insertOrderInfo.setId(1234L); //自动递增
            //系统订单号(订单唯一标识) 32位
            String uuid = UUID.randomUUID().toString().replace("-", "");
            insertOrderInfo.setSerial(uuid);
            //系统外部单号 == 服务商或代理
            insertOrderInfo.setOutSerial(oriOrderId);
            //渠道订单号，信联唯一
            insertOrderInfo.setChannelOrderNo(oriOrderId);
            //外部商户号 == 服务商或代理
            insertOrderInfo.setOutMchId(mchInfo.getOutMchNo());
            //系统商户号
            insertOrderInfo.setMchId(mchInfo.getId());
            //商户所属机构
            insertOrderInfo.setOrgId(mchInfo.getOrgId());
            //交易产生应用编号(这个可能用于订单推送到其他的系统使用)org_id与trade_org_id可能会不一致,只要标识订单产生来源
            if (mchInfo.getOrgId() != null) {
                insertOrderInfo.setOrgAppNo(mchInfo.getOrgId().toString());
            }
            //商户直属代理商
            insertOrderInfo.setAgentId(mchInfo.getAgentId());
            //商户名称(冗余)
            insertOrderInfo.setMchName(mchInfo.getMchName());
            insertOrderInfo.setChannelId(channelMchtXl.getChannelId());
            insertOrderInfo.setChannelMchNo(channelMchtXl.getChannelMchtNo());
            //TODO 查到原来的交易订单，然后把serial 存到 origSerial字段里面，做关联
            OrderInfo tradeOrderInfo = orderInfoService.selectByChannelOrderNo(oriOrderId);
            if (tradeOrderInfo!=null){
                //退款订单的原系统单号
                insertOrderInfo.setOrigSerial(tradeOrderInfo.getSerial());
                insertOrderInfo.setProduct(tradeOrderInfo.getProduct());
                insertOrderInfo.setSubProduct(tradeOrderInfo.getSubProduct());
                //原交易的退款状态也修改为 全额退款成功  或者新增字段，表示交易已退款
                OrderInfo updateOrderInfo=new OrderInfo();
                updateOrderInfo.setId(tradeOrderInfo.getId());
                updateOrderInfo.setRefundStatus("2");
                orderInfoService.updateByPrimaryKeySelective(updateOrderInfo);
            }
            //订单类型 1交易订单 2退款订单3预授权4分账订单
            insertOrderInfo.setOrderType("2");
            String payNotifyUrl = orgInterfceKey.getPayNotifyUrl();
            //订单通知地址   配置
            insertOrderInfo.setNotifyUrl(payNotifyUrl);
            //交易金额,分
            insertOrderInfo.setOrderAmount(trxAmt);
            boolean tradeSuccess = false;
            //交易状态映射   交易状态 70:交易失败，90:交易成功
            if ("70".equals(trxStatus)) {
                //本系统 交易状态-1 聚合码未扫码 0：未支付/处理中  1 成功 2 失败 3 申请退款 4退款成功（全部） 5退款失败 6交易关闭 7退款成功（部分）
                //交易失败 不通知
                insertOrderInfo.setTradeStatus("2");
            } else if ("90".equals(trxStatus)) {
                //订单日期yyyyMMdd 交易时间截取前8位
                insertOrderInfo.setOrderDate(tradeInfo.getTradeDate());
                insertOrderInfo.setFinishTime(tradeInfo.getTradeDate()+tradeInfo.getTradeTime());
                insertOrderInfo.setTradeStatus("1");
                tradeSuccess = true;
            }

            //订单来源 api 接口 notify 推送
            insertOrderInfo.setOrderSource("api");
            Date now = new Date();
            insertOrderInfo.setCreateTime(now);
            insertOrderInfo.setUpdateTime(now);
            orderInfoService.insert(insertOrderInfo);
            if (tradeSuccess) {
                addOrderNotifyLog(uuid,mchInfo.getOrgId(),payNotifyUrl);
            }
        }
    }

    /**
     * 插入通知表
     * @param uuid  订单号
     * @param orgId 机构id
     * @param payNotifyUrl  通知地址
     */
    private void addOrderNotifyLog(String uuid,Long orgId,String payNotifyUrl){
        //交易成功 需要新增通知表
        OrderNotifyLog orderNotifyLog = new OrderNotifyLog();
//            orderNotifyLog.setId(id);//自增
        //通知的订单号
        orderNotifyLog.setSerial(uuid);
        orderNotifyLog.setOrgId(orgId);
        orderNotifyLog.setNotifyUrl(payNotifyUrl);
        orderNotifyLog.setNotifyCount(0);
        //定时任务重试标识 0未重试1重试
        orderNotifyLog.setRetryFlag("0");
////            重试时间
//            orderNotifyLog.setRetryTime();
        //通知状态0未通知 1通知成功 2通知失败 3通知中
        orderNotifyLog.setNotifyStatus("0");
//            orderNotifyLog.setFailReason(failReason);
        Date now=new Date();
        orderNotifyLog.setCreateTime(now);
//            orderNotifyLog.setCreateId(createId);
        orderNotifyLog.setUpdateTime(now);
//            orderNotifyLog.setUpdateId(updateId);
        orderNotifyLogService.insert(orderNotifyLog);
    }
}
