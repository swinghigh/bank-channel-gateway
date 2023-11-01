package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrgInfo implements Serializable {
    private Long id;

    private String orgNo;

    private String orgName;

    private String contactName;

    private String contactPhone;

    private String status;

    private String orgType;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;
}