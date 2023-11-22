package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class ChannelMchtHy implements Serializable {
    private Long id;

    private Long mchId;

    private Long channelId;

    private String channelMchtNo;

    private String channelMchtName;

    private String shortName;

    private String categoryType;

    private String corEmail;

    private String corTel;

    private String scale;

    private String userType;

    private String businessLicenseNo;

    private String businessLicenseExpireStart;

    private String businessLicenseExpireEnd;

    private String contactName;

    private String contactTel;

    private String idNotType;

    private String idNo;

    private String issDate;

    private String province;

    private String city;

    private String expiryDate;

    private String district;

    private String address;

    private String remark;

    private String contactEmail;

    private String periods;

    private String channelName;

    private String feeMode;

    private String openQuick;

    private String appid;

    private String secret;

    private String status;

    private String failReason;

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

    public Long getMchId() {
        return mchId;
    }

    public void setMchId(Long mchId) {
        this.mchId = mchId;
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

    public String getChannelMchtName() {
        return channelMchtName;
    }

    public void setChannelMchtName(String channelMchtName) {
        this.channelMchtName = channelMchtName == null ? null : channelMchtName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType == null ? null : categoryType.trim();
    }

    public String getCorEmail() {
        return corEmail;
    }

    public void setCorEmail(String corEmail) {
        this.corEmail = corEmail == null ? null : corEmail.trim();
    }

    public String getCorTel() {
        return corTel;
    }

    public void setCorTel(String corTel) {
        this.corTel = corTel == null ? null : corTel.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo == null ? null : businessLicenseNo.trim();
    }

    public String getBusinessLicenseExpireStart() {
        return businessLicenseExpireStart;
    }

    public void setBusinessLicenseExpireStart(String businessLicenseExpireStart) {
        this.businessLicenseExpireStart = businessLicenseExpireStart == null ? null : businessLicenseExpireStart.trim();
    }

    public String getBusinessLicenseExpireEnd() {
        return businessLicenseExpireEnd;
    }

    public void setBusinessLicenseExpireEnd(String businessLicenseExpireEnd) {
        this.businessLicenseExpireEnd = businessLicenseExpireEnd == null ? null : businessLicenseExpireEnd.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getIdNotType() {
        return idNotType;
    }

    public void setIdNotType(String idNotType) {
        this.idNotType = idNotType == null ? null : idNotType.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getIssDate() {
        return issDate;
    }

    public void setIssDate(String issDate) {
        this.issDate = issDate == null ? null : issDate.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate == null ? null : expiryDate.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods == null ? null : periods.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getFeeMode() {
        return feeMode;
    }

    public void setFeeMode(String feeMode) {
        this.feeMode = feeMode == null ? null : feeMode.trim();
    }

    public String getOpenQuick() {
        return openQuick;
    }

    public void setOpenQuick(String openQuick) {
        this.openQuick = openQuick == null ? null : openQuick.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
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
        sb.append(", mchId=").append(mchId);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelMchtNo=").append(channelMchtNo);
        sb.append(", channelMchtName=").append(channelMchtName);
        sb.append(", shortName=").append(shortName);
        sb.append(", categoryType=").append(categoryType);
        sb.append(", corEmail=").append(corEmail);
        sb.append(", corTel=").append(corTel);
        sb.append(", scale=").append(scale);
        sb.append(", userType=").append(userType);
        sb.append(", businessLicenseNo=").append(businessLicenseNo);
        sb.append(", businessLicenseExpireStart=").append(businessLicenseExpireStart);
        sb.append(", businessLicenseExpireEnd=").append(businessLicenseExpireEnd);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactTel=").append(contactTel);
        sb.append(", idNotType=").append(idNotType);
        sb.append(", idNo=").append(idNo);
        sb.append(", issDate=").append(issDate);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", expiryDate=").append(expiryDate);
        sb.append(", district=").append(district);
        sb.append(", address=").append(address);
        sb.append(", remark=").append(remark);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", periods=").append(periods);
        sb.append(", channelName=").append(channelName);
        sb.append(", feeMode=").append(feeMode);
        sb.append(", openQuick=").append(openQuick);
        sb.append(", appid=").append(appid);
        sb.append(", secret=").append(secret);
        sb.append(", status=").append(status);
        sb.append(", failReason=").append(failReason);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}