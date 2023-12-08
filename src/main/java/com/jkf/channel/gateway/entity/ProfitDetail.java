package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class ProfitDetail implements Serializable {
    private Long id;

    private String profitOrg;

    private String profitOrgType;

    private String profitOrgName;

    private String virtualNo;

    private String profitType;

    private String profitRemark;

    private String profitOrgLevel;

    private String serial;

    private String product;

    private String cardType;

    private String applyId;

    private Long orgId;

    private String platSerial;

    private Long tradeAmount;

    private Long tradeChargeAmount;

    private Long tradeAddChargeAmount;

    private String tradeRate;

    private Long tradeChargeProfitAmount;

    private Long tradeAddChargeProfitAmount;

    private String tradeProfitRate;

    private Long otherProfitAmount;

    private Long totalProfitAmount;

    private String profitDate;

    private Long tradeMchtId;

    private String tradeFinishTime;

    private String source;

    private String tradeMchtName;

    private String checkStatus;

    private String checkName;

    private String checkRemark;

    private String settleStatus;

    private Date settleFinishTime;

    private String settlePatchNo;

    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

    private String profitAccountType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVirtualNo() {
        return virtualNo;
    }

    public void setVirtualNo(String virtualNo) {
        this.virtualNo = virtualNo == null ? null : virtualNo.trim();
    }

    public String getProfitType() {
        return profitType;
    }

    public void setProfitType(String profitType) {
        this.profitType = profitType == null ? null : profitType.trim();
    }

    public String getProfitRemark() {
        return profitRemark;
    }

    public void setProfitRemark(String profitRemark) {
        this.profitRemark = profitRemark == null ? null : profitRemark.trim();
    }

    public String getProfitOrgLevel() {
        return profitOrgLevel;
    }

    public void setProfitOrgLevel(String profitOrgLevel) {
        this.profitOrgLevel = profitOrgLevel == null ? null : profitOrgLevel.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getPlatSerial() {
        return platSerial;
    }

    public void setPlatSerial(String platSerial) {
        this.platSerial = platSerial == null ? null : platSerial.trim();
    }

    public Long getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Long getTradeChargeAmount() {
        return tradeChargeAmount;
    }

    public void setTradeChargeAmount(Long tradeChargeAmount) {
        this.tradeChargeAmount = tradeChargeAmount;
    }

    public Long getTradeAddChargeAmount() {
        return tradeAddChargeAmount;
    }

    public void setTradeAddChargeAmount(Long tradeAddChargeAmount) {
        this.tradeAddChargeAmount = tradeAddChargeAmount;
    }

    public String getTradeRate() {
        return tradeRate;
    }

    public void setTradeRate(String tradeRate) {
        this.tradeRate = tradeRate == null ? null : tradeRate.trim();
    }

    public Long getTradeChargeProfitAmount() {
        return tradeChargeProfitAmount;
    }

    public void setTradeChargeProfitAmount(Long tradeChargeProfitAmount) {
        this.tradeChargeProfitAmount = tradeChargeProfitAmount;
    }

    public Long getTradeAddChargeProfitAmount() {
        return tradeAddChargeProfitAmount;
    }

    public void setTradeAddChargeProfitAmount(Long tradeAddChargeProfitAmount) {
        this.tradeAddChargeProfitAmount = tradeAddChargeProfitAmount;
    }

    public String getTradeProfitRate() {
        return tradeProfitRate;
    }

    public void setTradeProfitRate(String tradeProfitRate) {
        this.tradeProfitRate = tradeProfitRate == null ? null : tradeProfitRate.trim();
    }

    public Long getOtherProfitAmount() {
        return otherProfitAmount;
    }

    public void setOtherProfitAmount(Long otherProfitAmount) {
        this.otherProfitAmount = otherProfitAmount;
    }

    public Long getTotalProfitAmount() {
        return totalProfitAmount;
    }

    public void setTotalProfitAmount(Long totalProfitAmount) {
        this.totalProfitAmount = totalProfitAmount;
    }

    public String getProfitDate() {
        return profitDate;
    }

    public void setProfitDate(String profitDate) {
        this.profitDate = profitDate == null ? null : profitDate.trim();
    }

    public Long getTradeMchtId() {
        return tradeMchtId;
    }

    public void setTradeMchtId(Long tradeMchtId) {
        this.tradeMchtId = tradeMchtId;
    }

    public String getTradeFinishTime() {
        return tradeFinishTime;
    }

    public void setTradeFinishTime(String tradeFinishTime) {
        this.tradeFinishTime = tradeFinishTime == null ? null : tradeFinishTime.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getTradeMchtName() {
        return tradeMchtName;
    }

    public void setTradeMchtName(String tradeMchtName) {
        this.tradeMchtName = tradeMchtName == null ? null : tradeMchtName.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName == null ? null : checkName.trim();
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus == null ? null : settleStatus.trim();
    }

    public Date getSettleFinishTime() {
        return settleFinishTime;
    }

    public void setSettleFinishTime(Date settleFinishTime) {
        this.settleFinishTime = settleFinishTime;
    }

    public String getSettlePatchNo() {
        return settlePatchNo;
    }

    public void setSettlePatchNo(String settlePatchNo) {
        this.settlePatchNo = settlePatchNo == null ? null : settlePatchNo.trim();
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

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getProfitAccountType() {
        return profitAccountType;
    }

    public void setProfitAccountType(String profitAccountType) {
        this.profitAccountType = profitAccountType == null ? null : profitAccountType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", profitOrg=").append(profitOrg);
        sb.append(", profitOrgType=").append(profitOrgType);
        sb.append(", profitOrgName=").append(profitOrgName);
        sb.append(", virtualNo=").append(virtualNo);
        sb.append(", profitType=").append(profitType);
        sb.append(", profitRemark=").append(profitRemark);
        sb.append(", profitOrgLevel=").append(profitOrgLevel);
        sb.append(", serial=").append(serial);
        sb.append(", product=").append(product);
        sb.append(", cardType=").append(cardType);
        sb.append(", applyId=").append(applyId);
        sb.append(", orgId=").append(orgId);
        sb.append(", platSerial=").append(platSerial);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append(", tradeChargeAmount=").append(tradeChargeAmount);
        sb.append(", tradeAddChargeAmount=").append(tradeAddChargeAmount);
        sb.append(", tradeRate=").append(tradeRate);
        sb.append(", tradeChargeProfitAmount=").append(tradeChargeProfitAmount);
        sb.append(", tradeAddChargeProfitAmount=").append(tradeAddChargeProfitAmount);
        sb.append(", tradeProfitRate=").append(tradeProfitRate);
        sb.append(", otherProfitAmount=").append(otherProfitAmount);
        sb.append(", totalProfitAmount=").append(totalProfitAmount);
        sb.append(", profitDate=").append(profitDate);
        sb.append(", tradeMchtId=").append(tradeMchtId);
        sb.append(", tradeFinishTime=").append(tradeFinishTime);
        sb.append(", source=").append(source);
        sb.append(", tradeMchtName=").append(tradeMchtName);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", checkName=").append(checkName);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", settleStatus=").append(settleStatus);
        sb.append(", settleFinishTime=").append(settleFinishTime);
        sb.append(", settlePatchNo=").append(settlePatchNo);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", profitAccountType=").append(profitAccountType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}