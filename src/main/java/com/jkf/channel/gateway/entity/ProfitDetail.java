package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProfitDetail implements Serializable {
    private Long id;

    private String profitOrg;

    private String profitOrgType;

    private String profitOrgName;

    private String virtualNo;

    private String profitType;

    private String profitRemark;

    private String profitOrgLevel;

    private String serial;

    private String product;

    private String cardType;

    private String applyId;

    private Long orgId;

    private String platSerial;

    private Long tradeAmount;

    private Long tradeChargeAmount;

    private Long tradeAddChargeAmount;

    private String tradeRate;

    private Long tradeChargeProfitAmount;

    private Long tradeAddChargeProfitAmount;

    private String tradeProfitRate;

    private Long otherProfitAmount;

    private Long totalProfitAmount;

    private String profitDate;

    private Long tradeMchtId;

    private String tradeFinishTime;

    private String source;

    private String tradeMchtName;

    private String checkStatus;

    private String checkName;

    private String settleStatus;

    private Date settleFinishTime;

    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

}