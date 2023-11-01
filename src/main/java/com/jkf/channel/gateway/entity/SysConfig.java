package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysConfig implements Serializable {
    private Long id;

    private String configName;

    private String configKey;

    private String configDesc;

    private String configValue;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;
}