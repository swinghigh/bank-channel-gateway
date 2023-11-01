package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderNotifyLog implements Serializable {
    private Long id;

    private String serial;

    private Long orgId;

    private String notifyUrl;

    private Integer notifyCount;

    private String retryFlag;

    private Date retryTime;

    private String notifyStatus;

    private String failReason;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;
}