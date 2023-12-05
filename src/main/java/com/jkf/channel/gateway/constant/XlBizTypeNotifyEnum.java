package com.jkf.channel.gateway.constant;

import lombok.Getter;

/**
 * OrderTypeEnum 订单类型 1交易订单 2退款订单3预授权4分账订单
 */
@Getter
public enum XlBizTypeNotifyEnum {
    PosMerAuditNotify("PosMerAuditNotify", "进件审核通知"),
    PayNotify("PayNotify", "支付通知"),
    RefundNotify("RefundNotify", "退款通知"),
    ;

    private String  bizType;

    private String name;

    XlBizTypeNotifyEnum(String  bizType, String name) {
        this.bizType = bizType;
        this.name = name;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
