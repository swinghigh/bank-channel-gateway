package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderDraw implements Serializable {
    private Long id;

    private String outSerial;

    private Long orgId;

    private String serial;

    private String virtualNo;

    private String profitOrg;

    private String profitOrgType;

    private String profitOrgName;

    private Long drawAmount;

    private Long drawChargeAmount;

    private Long virtualAmountPre;

    private Long virtualAmountFinish;

    private String chargeType;

    private String chargeCostRate;

    private Long chargeCostAmount;

    private String status;

    private String remark;

    private String virtualCustomer;

    private String channelReason;

    private Long channelId;

    private String channelMchtNo;

    private String channelMchtTermNo;

    private String channelOrderNo;

    private String drawTime;

    private Long channelCharge;

    private Long channelAddCharge;

    private String channelBillStatus;

    private String bankName;

    private String bankAccountNo;

    private String bankAccountName;

    private Long createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutSerial() {
        return outSerial;
    }

    public void setOutSerial(String outSerial) {
        this.outSerial = outSerial == null ? null : outSerial.trim();
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getVirtualNo() {
        return virtualNo;
    }

    public void setVirtualNo(String virtualNo) {
        this.virtualNo = virtualNo == null ? null : virtualNo.trim();
    }

    public String getProfitOrg() {
        return profitOrg;
    }

    public void setProfitOrg(String profitOrg) {
        this.profitOrg = profitOrg == null ? null : profitOrg.trim();
    }

    public String getProfitOrgType() {
        return profitOrgType;
    }

    public void setProfitOrgType(String profitOrgType) {
        this.profitOrgType = profitOrgType == null ? null : profitOrgType.trim();
    }

    public String getProfitOrgName() {
        return profitOrgName;
    }

    public void setProfitOrgName(String profitOrgName) {
        this.profitOrgName = profitOrgName == null ? null : profitOrgName.trim();
    }

    public Long getDrawAmount() {
        return drawAmount;
    }

    public void setDrawAmount(Long drawAmount) {
        this.drawAmount = drawAmount;
    }

    public Long getDrawChargeAmount() {
        return drawChargeAmount;
    }

    public void setDrawChargeAmount(Long drawChargeAmount) {
        this.drawChargeAmount = drawChargeAmount;
    }

    public Long getVirtualAmountPre() {
        return virtualAmountPre;
    }

    public void setVirtualAmountPre(Long virtualAmountPre) {
        this.virtualAmountPre = virtualAmountPre;
    }

    public Long getVirtualAmountFinish() {
        return virtualAmountFinish;
    }

    public void setVirtualAmountFinish(Long virtualAmountFinish) {
        this.virtualAmountFinish = virtualAmountFinish;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getChargeCostRate() {
        return chargeCostRate;
    }

    public void setChargeCostRate(String chargeCostRate) {
        this.chargeCostRate = chargeCostRate == null ? null : chargeCostRate.trim();
    }

    public Long getChargeCostAmount() {
        return chargeCostAmount;
    }

    public void setChargeCostAmount(Long chargeCostAmount) {
        this.chargeCostAmount = chargeCostAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getVirtualCustomer() {
        return virtualCustomer;
    }

    public void setVirtualCustomer(String virtualCustomer) {
        this.virtualCustomer = virtualCustomer == null ? null : virtualCustomer.trim();
    }

    public String getChannelReason() {
        return channelReason;
    }

    public void setChannelReason(String channelReason) {
        this.channelReason = channelReason == null ? null : channelReason.trim();
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

    public String getChannelMchtTermNo() {
        return channelMchtTermNo;
    }

    public void setChannelMchtTermNo(String channelMchtTermNo) {
        this.channelMchtTermNo = channelMchtTermNo == null ? null : channelMchtTermNo.trim();
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo == null ? null : channelOrderNo.trim();
    }

    public String getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(String drawTime) {
        this.drawTime = drawTime == null ? null : drawTime.trim();
    }

    public Long getChannelCharge() {
        return channelCharge;
    }

    public void setChannelCharge(Long channelCharge) {
        this.channelCharge = channelCharge;
    }

    public Long getChannelAddCharge() {
        return channelAddCharge;
    }

    public void setChannelAddCharge(Long channelAddCharge) {
        this.channelAddCharge = channelAddCharge;
    }

    public String getChannelBillStatus() {
        return channelBillStatus;
    }

    public void setChannelBillStatus(String channelBillStatus) {
        this.channelBillStatus = channelBillStatus == null ? null : channelBillStatus.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo == null ? null : bankAccountNo.trim();
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", outSerial=").append(outSerial);
        sb.append(", orgId=").append(orgId);
        sb.append(", serial=").append(serial);
        sb.append(", virtualNo=").append(virtualNo);
        sb.append(", profitOrg=").append(profitOrg);
        sb.append(", profitOrgType=").append(profitOrgType);
        sb.append(", profitOrgName=").append(profitOrgName);
        sb.append(", drawAmount=").append(drawAmount);
        sb.append(", drawChargeAmount=").append(drawChargeAmount);
        sb.append(", virtualAmountPre=").append(virtualAmountPre);
        sb.append(", virtualAmountFinish=").append(virtualAmountFinish);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", chargeCostRate=").append(chargeCostRate);
        sb.append(", chargeCostAmount=").append(chargeCostAmount);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", virtualCustomer=").append(virtualCustomer);
        sb.append(", channelReason=").append(channelReason);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelMchtNo=").append(channelMchtNo);
        sb.append(", channelMchtTermNo=").append(channelMchtTermNo);
        sb.append(", channelOrderNo=").append(channelOrderNo);
        sb.append(", drawTime=").append(drawTime);
        sb.append(", channelCharge=").append(channelCharge);
        sb.append(", channelAddCharge=").append(channelAddCharge);
        sb.append(", channelBillStatus=").append(channelBillStatus);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankAccountNo=").append(bankAccountNo);
        sb.append(", bankAccountName=").append(bankAccountName);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}