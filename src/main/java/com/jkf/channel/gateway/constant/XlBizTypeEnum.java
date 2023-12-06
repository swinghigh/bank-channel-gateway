package com.jkf.channel.gateway.constant;

import lombok.Getter;

/**
 * XlBizTypeEnum
 * 业务类型    CheckPayOrder-收单对账文件，CheckPaymentOrder-付款对账文件
 */
@Getter
public enum XlBizTypeEnum {
    CheckPayOrder("CheckPayOrder", "收单对账文件"),
    CheckPaymentOrder("CheckPaymentOrder", "付款对账文件"),

    ;

    private String  bizType;

    private String name;

    XlBizTypeEnum(String  bizType, String name) {
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
