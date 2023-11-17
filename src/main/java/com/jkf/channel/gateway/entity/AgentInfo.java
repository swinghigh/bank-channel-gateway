package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AgentInfo implements Serializable {
    private Long id;
    /**
     * 上级代理商编号
     */
    private Long pAgentId;
    /**
     * 所属机构
     */
    private Long orgId;
    /**
     * 外部代理商编号
     */
    private String outAgentNo;
    /**
     * 代理商编号,系统生成
     */
    private String agentNo;
    /**
     * 代理名称
     */
    private String agentName;
    /**
     * 省编码
     */
    private String proviceCode;
    /**
     * 市编码
     */
    private String cityCode;
    /**
     * 区县编码
     */
    private String countryCode;
    /**
     * 省市区的名称的，以逗号分割
     */
    private String addressName;
    /**
     * 地址
     */
    private String address;
    /**
     * 类型商户类型：1-公司，2-个体商 3-小微
     */
    private String agentType;
    /**
     * 营业执照编号
     */
    private String businessLicense;
    /**
     * 营业执照注册金额
     */
    private String businessAmt;
    /**
     *营业执照开始时间yyyy-MM-dd
     */
    private String businessExpireStart;
    /**
     * 营业执照结束时间yyyy-MM-dd长期转成2199-12-31
     */
    private String businessExpireEnd;
    /**
     * 法人姓名
     */
    private String legalName;

    private String legalCertType;

    private String legalCertNo;

    private String legalPhone;

    private String legalExpireStart;

    private String legalExpireEnd;

    private String contactName;

    private String contactCertType;

    private String contactCertNo;

    private String contactPhone;

    private String contactEmail;
    /**
     * 代理商状态0-正式、1-停用、2-待提交资质、3-审核中
     */
    private String status;

    private String checkRemark;

    private String agentNature;

    private String agentLevel;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private String virtualNo;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pAgentId=").append(pAgentId);
        sb.append(", orgId=").append(orgId);
        sb.append(", outAgentNo=").append(outAgentNo);
        sb.append(", agentNo=").append(agentNo);
        sb.append(", agentName=").append(agentName);
        sb.append(", proviceCode=").append(proviceCode);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", address=").append(address);
        sb.append(", agentType=").append(agentType);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", businessAmt=").append(businessAmt);
        sb.append(", businessExpireStart=").append(businessExpireStart);
        sb.append(", businessExpireEnd=").append(businessExpireEnd);
        sb.append(", legalName=").append(legalName);
        sb.append(", legalCertType=").append(legalCertType);
        sb.append(", legalCertNo=").append(legalCertNo);
        sb.append(", legalPhone=").append(legalPhone);
        sb.append(", legalExpireStart=").append(legalExpireStart);
        sb.append(", legalExpireEnd=").append(legalExpireEnd);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactCertType=").append(contactCertType);
        sb.append(", contactCertNo=").append(contactCertNo);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", status=").append(status);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", agentNature=").append(agentNature);
        sb.append(", agentLevel=").append(agentLevel);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", virtualNo=").append(virtualNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}