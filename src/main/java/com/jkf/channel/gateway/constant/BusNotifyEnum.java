package com.jkf.channel.gateway.constant;

import lombok.Getter;

/**
 * OrderTypeEnum 订单类型 1交易订单 2退款订单3预授权4分账订单
 */
@Getter
public enum BusNotifyEnum {
    XL_REGISTER("XL_REGISTER", "信联入网审核通知"),
    XL_PAY("XL_PAY", "信联支付结果通知"),
    XL_REFUND("XL_REFUND", "信联退款结果通知"),
    ;

    private String  bussType;

    private String name;

    BusNotifyEnum(String  bussType, String name) {
        this.bussType = bussType;
        this.name = name;
    }

    public String getBussType() {
        return bussType;
    }

    public void setBussType(String bussType) {
        this.bussType = bussType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
