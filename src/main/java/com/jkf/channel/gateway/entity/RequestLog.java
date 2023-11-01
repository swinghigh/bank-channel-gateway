package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RequestLog implements Serializable {
    private Long id;

    private String path;

    private Long waitTime;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private String reqparam;

    private String resparam;

    private static final long serialVersionUID = 1L;
}