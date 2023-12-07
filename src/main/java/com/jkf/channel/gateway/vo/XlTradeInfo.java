package com.jkf.channel.gateway.vo;

import lombok.Data;

/**
 * 信联 对账交易信息封装
 */
@Data
public class XlTradeInfo {
    //订单发起日期|订单发起时间|交易日期|交易时间|商户订单号|支付方式|交易类型|交易状态|订单金额|手续费|信联支付流水号|客户标识|订单来源|退汇状态
    /**
     * 订单发起日期 yyyyMMdd
     */
    private String orderStartDate;
    /**
     * 订单发起时间 HHMMSS
     */
    private String orderStartTime;
    /**
     * 交易日期 yyyyMMdd
     */
    private String tradeDate;
    /**
     * 交易时间  HHMMSS
     */
    private String tradeTime;

    /**
     * 商户订单号  对应orderInfo的channelOrderNo
     */
    private String oriOrderId;

    /**
     * 信联 支付方式  交易类别13-微信用户被扫，15-微信用户主扫，22-支付宝用户主扫，23-支付宝被扫，53-银联用户主扫
     */
    private String trxCtgy;
    /**
     * 信联 交易类型 2001-支付，2002-退款
     */
    private String transactionType;
    /**
     * 交易状态70:交易失败，90:交易成功
     */
    private String trxStatus;
    /**
     * 交易金额 这里单位是 元  要转分存库
     */
    private String trxAmt;
    /**
     * 手续费  这里单位是元  要转分存库
     */
    private String chargeAmt;
    /**
     * 信联支付流水号 存库就是orderInfo 的 channelOrderNo
     */
    private String xlSerialNo;
    /**
     * 客户标识
     */
    private String customerIdentifier;
    /**
     * 订单来源
     */
    private String orderSource;
    /**
     * 退汇状态
     */
    private String refundStatus;
}
