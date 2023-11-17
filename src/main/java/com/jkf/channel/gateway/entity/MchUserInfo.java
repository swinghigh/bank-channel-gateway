package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MchUserInfo implements Serializable {
    private Long id;

    private String outUserId;

    private Long pUserId;

    private Long agentId;

    private Long orgId;

    private String userNo;

    private String userName;

    private String userNick;

    private String userPhone;

    private String userLogin;

    private String userPassword;

    private String userEmail;

    private String status;

    private Long mchId;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", outUserId=").append(outUserId);
        sb.append(", pUserId=").append(pUserId);
        sb.append(", agentId=").append(agentId);
        sb.append(", orgId=").append(orgId);
        sb.append(", userNo=").append(userNo);
        sb.append(", userName=").append(userName);
        sb.append(", userNick=").append(userNick);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userLogin=").append(userLogin);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", status=").append(status);
        sb.append(", mchId=").append(mchId);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}