package com.jkf.channel.gateway.entity;

import java.io.Serializable;
import java.util.Date;

public class ChannelMchtXl implements Serializable {
    private Long id;

    private Long mchId;

    private Long channelId;

    private String channelMchtNo;

    private String channelMchtName;

    private String orderId;

    private String loginPassword;

    private String userName;

    private String notifyUrl;

    private String notifyFlag;

    private String checkStatus;

    private String checkMessage;

    private Date checkTime;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private String outApplyId;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getNotifyFlag() {
        return notifyFlag;
    }

    public void setNotifyFlag(String notifyFlag) {
        this.notifyFlag = notifyFlag == null ? null : notifyFlag.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public String getCheckMessage() {
        return checkMessage;
    }

    public void setCheckMessage(String checkMessage) {
        this.checkMessage = checkMessage == null ? null : checkMessage.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
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

    public String getOutApplyId() {
        return outApplyId;
    }

    public void setOutApplyId(String outApplyId) {
        this.outApplyId = outApplyId == null ? null : outApplyId.trim();
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
        sb.append(", orderId=").append(orderId);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", userName=").append(userName);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", notifyFlag=").append(notifyFlag);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", checkMessage=").append(checkMessage);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", outApplyId=").append(outApplyId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}