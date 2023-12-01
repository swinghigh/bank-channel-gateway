package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderInfo implements Serializable {
    private Long id;

    private String serial;

    private String outSerial;

    private String outMchId;

    private Long mchId;

    private Long orgId;

    private String orgAppNo;

    private Long agentId;

    private Long userId;

    private Long shopId;

    private String mchName;

    private String sn;

    private String termSn;

    private Long channelId;

    private String channelMchNo;

    private String channelTermNo;

    private String channelOrderNo;

    private String tradeNo;

    private String outTradeNo;

    private String origSerial;

    private String orderType;

    private String product;

    private String subProduct;

    private String orderDate;

    private String notifyUrl;

    private String frontUrl;

    private Long orderAmount;

    private Long couponAmount;

    private String subject;

    private String subAppid;

    private String subOpenid;

    private String authCode;

    private String clientIp;

    private String longitude;

    private String latitude;

    private Long expireTime;

    private String limitPay;

    private String orderExt;

    private String tradeStatus;

    private String refundStatus;

    private String splitStatus;

    private String billStatus;

    private String settleStatus;

    private String finishTime;

    private String cardType;

    private Long chargeAmount;

    private String chargeRate;

    private Long addFeeAmount;

    private String advanceFlag;

    private String settleCycle;

    private String remark;

    private String orderSource;

    private String sourceApp;

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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getOutSerial() {
        return outSerial;
    }

    public void setOutSerial(String outSerial) {
        this.outSerial = outSerial == null ? null : outSerial.trim();
    }

    public String getOutMchId() {
        return outMchId;
    }

    public void setOutMchId(String outMchId) {
        this.outMchId = outMchId == null ? null : outMchId.trim();
    }

    public Long getMchId() {
        return mchId;
    }

    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgAppNo() {
        return orgAppNo;
    }

    public void setOrgAppNo(String orgAppNo) {
        this.orgAppNo = orgAppNo == null ? null : orgAppNo.trim();
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName == null ? null : mchName.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getTermSn() {
        return termSn;
    }

    public void setTermSn(String termSn) {
        this.termSn = termSn == null ? null : termSn.trim();
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelMchNo() {
        return channelMchNo;
    }

    public void setChannelMchNo(String channelMchNo) {
        this.channelMchNo = channelMchNo == null ? null : channelMchNo.trim();
    }

    public String getChannelTermNo() {
        return channelTermNo;
    }

    public void setChannelTermNo(String channelTermNo) {
        this.channelTermNo = channelTermNo == null ? null : channelTermNo.trim();
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo == null ? null : channelOrderNo.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getOrigSerial() {
        return origSerial;
    }

    public void setOrigSerial(String origSerial) {
        this.origSerial = origSerial == null ? null : origSerial.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct == null ? null : subProduct.trim();
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate == null ? null : orderDate.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl == null ? null : frontUrl.trim();
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Long couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid == null ? null : subAppid.trim();
    }

    public String getSubOpenid() {
        return subOpenid;
    }

    public void setSubOpenid(String subOpenid) {
        this.subOpenid = subOpenid == null ? null : subOpenid.trim();
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode == null ? null : authCode.trim();
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay == null ? null : limitPay.trim();
    }

    public String getOrderExt() {
        return orderExt;
    }

    public void setOrderExt(String orderExt) {
        this.orderExt = orderExt == null ? null : orderExt.trim();
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    public String getSplitStatus() {
        return splitStatus;
    }

    public void setSplitStatus(String splitStatus) {
        this.splitStatus = splitStatus == null ? null : splitStatus.trim();
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus == null ? null : settleStatus.trim();
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public Long getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Long chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(String chargeRate) {
        this.chargeRate = chargeRate == null ? null : chargeRate.trim();
    }

    public Long getAddFeeAmount() {
        return addFeeAmount;
    }

    public void setAddFeeAmount(Long addFeeAmount) {
        this.addFeeAmount = addFeeAmount;
    }

    public String getAdvanceFlag() {
        return advanceFlag;
    }

    public void setAdvanceFlag(String advanceFlag) {
        this.advanceFlag = advanceFlag == null ? null : advanceFlag.trim();
    }

    public String getSettleCycle() {
        return settleCycle;
    }

    public void setSettleCycle(String settleCycle) {
        this.settleCycle = settleCycle == null ? null : settleCycle.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource == null ? null : orderSource.trim();
    }

    public String getSourceApp() {
        return sourceApp;
    }

    public void setSourceApp(String sourceApp) {
        this.sourceApp = sourceApp == null ? null : sourceApp.trim();
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
        sb.append(", serial=").append(serial);
        sb.append(", outSerial=").append(outSerial);
        sb.append(", outMchId=").append(outMchId);
        sb.append(", mchId=").append(mchId);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgAppNo=").append(orgAppNo);
        sb.append(", agentId=").append(agentId);
        sb.append(", userId=").append(userId);
        sb.append(", shopId=").append(shopId);
        sb.append(", mchName=").append(mchName);
        sb.append(", sn=").append(sn);
        sb.append(", termSn=").append(termSn);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelMchNo=").append(channelMchNo);
        sb.append(", channelTermNo=").append(channelTermNo);
        sb.append(", channelOrderNo=").append(channelOrderNo);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", origSerial=").append(origSerial);
        sb.append(", orderType=").append(orderType);
        sb.append(", product=").append(product);
        sb.append(", subProduct=").append(subProduct);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", frontUrl=").append(frontUrl);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", subject=").append(subject);
        sb.append(", subAppid=").append(subAppid);
        sb.append(", subOpenid=").append(subOpenid);
        sb.append(", authCode=").append(authCode);
        sb.append(", clientIp=").append(clientIp);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", limitPay=").append(limitPay);
        sb.append(", orderExt=").append(orderExt);
        sb.append(", tradeStatus=").append(tradeStatus);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", splitStatus=").append(splitStatus);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", settleStatus=").append(settleStatus);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", cardType=").append(cardType);
        sb.append(", chargeAmount=").append(chargeAmount);
        sb.append(", chargeRate=").append(chargeRate);
        sb.append(", addFeeAmount=").append(addFeeAmount);
        sb.append(", advanceFlag=").append(advanceFlag);
        sb.append(", settleCycle=").append(settleCycle);
        sb.append(", remark=").append(remark);
        sb.append(", orderSource=").append(orderSource);
        sb.append(", sourceApp=").append(sourceApp);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}