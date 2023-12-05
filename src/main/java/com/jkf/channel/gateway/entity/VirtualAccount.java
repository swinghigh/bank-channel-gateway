package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class VirtualAccount implements Serializable {
    private Long id;

    private String virtualNo;

    private String virtualName;

    private String virtualAccountType;

    private String useAmount;

    private String disUseAmount;

    private String freezeAmount;

    private String encryAmount;

    private String status;

    private String pwd;

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

    public String getVirtualNo() {
        return virtualNo;
    }

    public void setVirtualNo(String virtualNo) {
        this.virtualNo = virtualNo == null ? null : virtualNo.trim();
    }

    public String getVirtualName() {
        return virtualName;
    }

    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName == null ? null : virtualName.trim();
    }

    public String getVirtualAccountType() {
        return virtualAccountType;
    }

    public void setVirtualAccountType(String virtualAccountType) {
        this.virtualAccountType = virtualAccountType == null ? null : virtualAccountType.trim();
    }

    public String getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount == null ? null : useAmount.trim();
    }

    public String getDisUseAmount() {
        return disUseAmount;
    }

    public void setDisUseAmount(String disUseAmount) {
        this.disUseAmount = disUseAmount == null ? null : disUseAmount.trim();
    }

    public String getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(String freezeAmount) {
        this.freezeAmount = freezeAmount == null ? null : freezeAmount.trim();
    }

    public String getEncryAmount() {
        return encryAmount;
    }

    public void setEncryAmount(String encryAmount) {
        this.encryAmount = encryAmount == null ? null : encryAmount.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
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
        sb.append(", virtualNo=").append(virtualNo);
        sb.append(", virtualName=").append(virtualName);
        sb.append(", virtualAccountType=").append(virtualAccountType);
        sb.append(", useAmount=").append(useAmount);
        sb.append(", disUseAmount=").append(disUseAmount);
        sb.append(", freezeAmount=").append(freezeAmount);
        sb.append(", encryAmount=").append(encryAmount);
        sb.append(", status=").append(status);
        sb.append(", pwd=").append(pwd);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}