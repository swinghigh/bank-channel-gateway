package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class InterfaceInfo implements Serializable {
    private Long id;

    private String interfaceCode;

    private String interfaceName;

    private String interfaceDesc;

    private String interfaceStatus;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;
}