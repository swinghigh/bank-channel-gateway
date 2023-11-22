package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrgInterfacePermission implements Serializable {
    private Long id;

    private String orgAppNo;

    private Long interfaceId;

    private String interfaceCode;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orgAppNo=").append(orgAppNo);
        sb.append(", interfaceId=").append(interfaceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}