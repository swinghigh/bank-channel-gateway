package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MchInfo implements Serializable {
    private Long id;

    private String outMchNo;

    private String mchNo;

    private Long orgId;

    private Long agentId;

    private String mchName;

    private Long userAdminId;

    private String mchStatus;

    private String mchType;

    private String mchShortName;

    private String registerAddress;

    private String businessProviceCode;

    private String businessCityCode;

    private String businessCountyCode;

    private String businessAddress;

    private String businessAddressName;

    private String businessLicense;

    private String businessAmt;

    private String businessExpireStart;

    private String businessExpireEnd;

    private String businessInfo;

    private String enterpriseCategory;

    private String enterpriseScale;

    private String mcc;

    private String legalName;

    private String legalCertType;

    private String legalCertNo;

    private String legalPhone;

    private String legalExpireStart;

    private String legalExpireEnd;

    private String legalCertAddress;

    private String contactName;

    private String contactCertType;

    private String contactCertNo;

    private String contactPhone;

    private String contactExpireStart;

    private String contactExpireEnd;

    private String contactAddress;

    private String contactEmail;

    private String remark;

    private String checkRemark;

    private String passTime;

    private String mchSource;

    private String settleCycle;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private Long channelId;


    private String virtualNo;
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", outMchNo=").append(outMchNo);
        sb.append(", mchNo=").append(mchNo);
        sb.append(", orgId=").append(orgId);
        sb.append(", agentId=").append(agentId);
        sb.append(", mchName=").append(mchName);
        sb.append(", userAdminId=").append(userAdminId);
        sb.append(", mchStatus=").append(mchStatus);
        sb.append(", mchType=").append(mchType);
        sb.append(", mchShortName=").append(mchShortName);
        sb.append(", registerAddress=").append(registerAddress);
        sb.append(", businessProviceCode=").append(businessProviceCode);
        sb.append(", businessCityCode=").append(businessCityCode);
        sb.append(", businessCountyCode=").append(businessCountyCode);
        sb.append(", businessAddress=").append(businessAddress);
        sb.append(", businessAddressName=").append(businessAddressName);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", businessAmt=").append(businessAmt);
        sb.append(", businessExpireStart=").append(businessExpireStart);
        sb.append(", businessExpireEnd=").append(businessExpireEnd);
        sb.append(", businessInfo=").append(businessInfo);
        sb.append(", enterpriseCategory=").append(enterpriseCategory);
        sb.append(", enterpriseScale=").append(enterpriseScale);
        sb.append(", mcc=").append(mcc);
        sb.append(", legalName=").append(legalName);
        sb.append(", legalCertType=").append(legalCertType);
        sb.append(", legalCertNo=").append(legalCertNo);
        sb.append(", legalPhone=").append(legalPhone);
        sb.append(", legalExpireStart=").append(legalExpireStart);
        sb.append(", legalExpireEnd=").append(legalExpireEnd);
        sb.append(", legalCertAddress=").append(legalCertAddress);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactCertType=").append(contactCertType);
        sb.append(", contactCertNo=").append(contactCertNo);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", contactExpireStart=").append(contactExpireStart);
        sb.append(", contactExpireEnd=").append(contactExpireEnd);
        sb.append(", contactAddress=").append(contactAddress);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", remark=").append(remark);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", passTime=").append(passTime);
        sb.append(", mchSource=").append(mchSource);
        sb.append(", settleCycle=").append(settleCycle);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}