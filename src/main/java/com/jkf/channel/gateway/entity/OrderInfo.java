package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderInfo implements Serializable {
    private Long id;

    private String serial;

    private String outSerial;

    private String outMchId;

    private Long mchId;

    private Long orgId;

    private Long tradeOrgId;

    private Long userId;

    private Long shopId;

    private String mchName;

    private String sn;

    private String termSn;

    private Long channelId;

    private String channelMchNo;

    private String channelTermNo;

    private String channelOrderNo;

    private String tradeNo;

    private String outTradeNo;

    private String origSerial;

    private String orderType;

    private String product;

    private String subProduct;

    private String orderDate;

    private String notifyUrl;

    private String frontUrl;

    private Long orderAmount;

    private Long couponAmount;

    private String subject;

    private String subAppid;

    private String subOpenid;

    private String authCode;

    private String clientIp;

    private String longitude;

    private String latitude;

    private Long expireTime;

    private String limitPay;

    private String orderExt;

    private String tradeStatus;

    private String billStatus;

    private String settleStatus;

    private String finishTime;

    private String cardType;

    private Long chargeAmount;

    private String chargeRate;

    private Long addFeeAmount;

    private String advanceFlag;

    private String remark;

    private String orderSource;

    private String sourceApp;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;
}