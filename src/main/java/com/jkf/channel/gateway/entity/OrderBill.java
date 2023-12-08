package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderBill implements Serializable {
    private Long id;

    private String patchNo;

    private Long channelId;

    private String channelMchtNo;

    private String channelOrderNo;

    private String serial;

    private String billDate;

    private Long mchId;

    private Long agentId;

    private Long orgId;

    private String orderType;

    private Long orderAmount;

    private Long chargeAmount;

    private Long addFeeAmount;

    private Long settleAmount;

    private String finishTime;

    private String status;

    private String exitFlag;

    private String remark;

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

    public String getPatchNo() {
        return patchNo;
    }

    public void setPatchNo(String patchNo) {
        this.patchNo = patchNo == null ? null : patchNo.trim();
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelMchtNo() {
        return channelMchtNo;
    }

    public void setChannelMchtNo(String channelMchtNo) {
        this.channelMchtNo = channelMchtNo == null ? null : channelMchtNo.trim();
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo == null ? null : channelOrderNo.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    public Long getMchId() {
        return mchId;
    }

    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Long chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Long getAddFeeAmount() {
        return addFeeAmount;
    }

    public void setAddFeeAmount(Long addFeeAmount) {
        this.addFeeAmount = addFeeAmount;
    }

    public Long getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(Long settleAmount) {
        this.settleAmount = settleAmount;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getExitFlag() {
        return exitFlag;
    }

    public void setExitFlag(String exitFlag) {
        this.exitFlag = exitFlag == null ? null : exitFlag.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        sb.append(", patchNo=").append(patchNo);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelMchtNo=").append(channelMchtNo);
        sb.append(", channelOrderNo=").append(channelOrderNo);
        sb.append(", serial=").append(serial);
        sb.append(", billDate=").append(billDate);
        sb.append(", mchId=").append(mchId);
        sb.append(", agentId=").append(agentId);
        sb.append(", orgId=").append(orgId);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", chargeAmount=").append(chargeAmount);
        sb.append(", addFeeAmount=").append(addFeeAmount);
        sb.append(", settleAmount=").append(settleAmount);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", status=").append(status);
        sb.append(", exitFlag=").append(exitFlag);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}