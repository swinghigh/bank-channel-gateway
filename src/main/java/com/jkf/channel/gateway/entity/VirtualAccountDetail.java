package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class VirtualAccountDetail implements Serializable {
    private Long id;

    private String virtualNo;

    private String isAdd;

    private String actType;

    private String amount;

    private String charge;

    private String finalAmount;

    private String remark;

    private String actDate;

    private String serial;

    private String addBlance;

    private String addName;

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

    public String getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(String isAdd) {
        this.isAdd = isAdd == null ? null : isAdd.trim();
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType == null ? null : actType.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge == null ? null : charge.trim();
    }

    public String getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(String finalAmount) {
        this.finalAmount = finalAmount == null ? null : finalAmount.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getActDate() {
        return actDate;
    }

    public void setActDate(String actDate) {
        this.actDate = actDate == null ? null : actDate.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getAddBlance() {
        return addBlance;
    }

    public void setAddBlance(String addBlance) {
        this.addBlance = addBlance == null ? null : addBlance.trim();
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName == null ? null : addName.trim();
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
        sb.append(", isAdd=").append(isAdd);
        sb.append(", actType=").append(actType);
        sb.append(", amount=").append(amount);
        sb.append(", charge=").append(charge);
        sb.append(", finalAmount=").append(finalAmount);
        sb.append(", remark=").append(remark);
        sb.append(", actDate=").append(actDate);
        sb.append(", serial=").append(serial);
        sb.append(", addBlance=").append(addBlance);
        sb.append(", addName=").append(addName);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}