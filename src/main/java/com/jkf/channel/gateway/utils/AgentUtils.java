package com.jkf.channel.gateway.utils;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.entity.AgentInfo;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/14 19:47
 */
public class AgentUtils {

    public static AgentInfo buildAgentInfo(JSONObject param){
        AgentInfo agentInfo=new AgentInfo();
        if(!StringUtils.isEmpty(param.getString("pAgentId"))){
            agentInfo.setPAgentId(Long.parseLong(param.getString("pAgentId")));
        }
        agentInfo.setOutAgentNo(param.getString("outAgentNo"));
        agentInfo.setOrgId(Long.parseLong(param.getString("orgId")));
        agentInfo.setAgentName(param.getString("agentName"));
        agentInfo.setProviceCode(param.getString("proviceCode"));
        agentInfo.setCityCode(param.getString("cityCode"));
        agentInfo.setCountryCode(param.getString("countryCode"));
        agentInfo.setAddress(param.getString("address"));
        agentInfo.setAgentType(param.getString("agentType"));
        agentInfo.setBusinessLicense(param.getString("businessLicense"));
        agentInfo.setBusinessAmt(param.getString("businessAmt"));
        agentInfo.setBusinessExpireStart(param.getString("businessExpireStart"));
        agentInfo.setBusinessExpireEnd(param.getString("businessExpireEnd"));
        agentInfo.setLegalName(param.getString("legalName"));
        agentInfo.setLegalCertType(param.getString("legalCertType"));
        if(!StringUtils.isEmpty(param.getString("legalCertNo"))) {
            agentInfo.setLegalCertNo(AESUtil.encrypt(param.getString("legalCertNo"),AESUtil.key));
        }
        if(!StringUtils.isEmpty(param.getString("legalPhone"))) {
            agentInfo.setLegalPhone(AESUtil.encrypt(param.getString("legalPhone"),AESUtil.key));
        }
        agentInfo.setLegalExpireStart(param.getString("legalExpireStart"));
        agentInfo.setLegalExpireEnd(param.getString("legalExpireEnd"));
        agentInfo.setContactName(param.getString("contactName"));
        agentInfo.setContactCertType(param.getString("contactCertType"));
        if(!StringUtils.isEmpty(param.getString("contactCertNo"))) {
            agentInfo.setContactCertNo(AESUtil.encrypt(param.getString("contactCertNo"),AESUtil.key));
        }
        if(!StringUtils.isEmpty(param.getString("contactPhone"))) {
            agentInfo.setContactPhone(AESUtil.encrypt(param.getString("contactPhone"),AESUtil.key));
        }
        agentInfo.setContactEmail(param.getString("contactEmail"));
        return agentInfo;
    }
}
