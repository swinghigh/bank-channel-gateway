package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChannelPro implements Serializable {
    private Long id;

    private Long channelId;

    private String keyName;

    private String keyValue;

    private String keyDesc;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;
}