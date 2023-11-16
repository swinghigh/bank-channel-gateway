package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrgInterfacePermission implements Serializable {
    private Long id;

    private String orgNo;

    private Long interfaceId;
    /**
     * 需要关联查询才有值
     */
    private String interfaceCode;

    private static final long serialVersionUID = 1L;
}