package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class OrgInterfceKey implements Serializable {
    private Long id;

    private String orgAppNo;

    private String orgAppName;

    private Long orgId;

    private String orgPrivateKey;

    private String orgPublicKey;

    private String platPrivateKey;

    private String platPublicKey;

    private String payNotifyUrl;

    private String status;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgAppNo() {
        return orgAppNo;
    }

    public void setOrgAppNo(String orgAppNo) {
        this.orgAppNo = orgAppNo == null ? null : orgAppNo.trim();
    }

    public String getOrgAppName() {
        return orgAppName;
    }

    public void setOrgAppName(String orgAppName) {
        this.orgAppName = orgAppName == null ? null : orgAppName.trim();
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgPrivateKey() {
        return orgPrivateKey;
    }

    public void setOrgPrivateKey(String orgPrivateKey) {
        this.orgPrivateKey = orgPrivateKey == null ? null : orgPrivateKey.trim();
    }

    public String getOrgPublicKey() {
        return orgPublicKey;
    }

    public void setOrgPublicKey(String orgPublicKey) {
        this.orgPublicKey = orgPublicKey == null ? null : orgPublicKey.trim();
    }

    public String getPlatPrivateKey() {
        return platPrivateKey;
    }

    public void setPlatPrivateKey(String platPrivateKey) {
        this.platPrivateKey = platPrivateKey == null ? null : platPrivateKey.trim();
    }

    public String getPlatPublicKey() {
        return platPublicKey;
    }

    public void setPlatPublicKey(String platPublicKey) {
        this.platPublicKey = platPublicKey == null ? null : platPublicKey.trim();
    }

    public String getPayNotifyUrl() {
        return payNotifyUrl;
    }

    public void setPayNotifyUrl(String payNotifyUrl) {
        this.payNotifyUrl = payNotifyUrl == null ? null : payNotifyUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orgAppNo=").append(orgAppNo);
        sb.append(", orgAppName=").append(orgAppName);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgPrivateKey=").append(orgPrivateKey);
        sb.append(", orgPublicKey=").append(orgPublicKey);
        sb.append(", platPrivateKey=").append(platPrivateKey);
        sb.append(", platPublicKey=").append(platPublicKey);
        sb.append(", payNotifyUrl=").append(payNotifyUrl);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}