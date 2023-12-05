package com.jkf.channel.gateway.constant;

import lombok.Getter;

/**
 * OrderTypeEnum 订单类型 1交易订单 2退款订单3预授权4分账订单
 */
@Getter
public enum OrderTypeEnum {
    PAY("1", "交易订单"),
    REFUND("2", "退款订单");

    private String code;

    private String name;

    OrderTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
