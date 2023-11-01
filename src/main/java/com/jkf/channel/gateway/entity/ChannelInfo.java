package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChannelInfo implements Serializable {
    private Long id;

    private String channelNo;

    private String channelName;

    private String channelcompanyNo;

    private String channelCompanyName;

    private String channelContact;

    private String channelPrivateKey;

    private String channelPublicKey;

    private String channelCompanyPublicKey;

    private String channelSaltKey;

    private String channelStatus;

    private Integer channelOrder;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;
}