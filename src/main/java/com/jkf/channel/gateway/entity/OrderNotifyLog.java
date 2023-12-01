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
    /**
     * 通知状态0未通知 1通知成功 2通知失败 3通知中
     */
    private String notifyStatus;

    private String failReason;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;
}