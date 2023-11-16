package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.AgentInfoMapper;
import com.jkf.channel.gateway.entity.AgentInfo;
import com.jkf.channel.gateway.entity.AgentInfoExample;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/16 13:53
 */
@Service
public class AgentQueryHandler implements IOpenHandler {
    @Resource
    private AgentInfoMapper agentInfoMapper;
    @Override
    public String getMethod() {
        return OpenMethodEnum.AGENT_QUERY.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("outAgentNo"), ErrorCode.PARAM_ERROR.getErrorCode(),"机构代理商编号为空");
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(),"所属机构为空");
        AgentInfoExample example=new AgentInfoExample();
        example.createCriteria().andOutAgentNoEqualTo(jsonObject.getString("outAgentNo")).andOrgIdEqualTo(jsonObject.getLong("orgId"));
        List<AgentInfo> agentInfos=agentInfoMapper.selectByExample(example);
        AssertUtils.collectIsEmpty(agentInfos,ErrorCode.PARAM_ERROR.getErrorCode(),"代理商不存在");
        AgentInfo agentInfo=agentInfos.get(0);
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "上传成功");
        result.put("agentId", agentInfo.getId());
        result.put("agentName", agentInfo.getAgentName());
        result.put("proviceCode", agentInfo.getProviceCode());
        result.put("cityCode", agentInfo.getCityCode());
        result.put("countryCode", agentInfo.getCountryCode());
        result.put("address", agentInfo.getAddress());
        result.put("agentType", agentInfo.getAgentType());
        result.put("businessLicense", agentInfo.getBusinessLicense());
        result.put("businessAmt", agentInfo.getBusinessAmt());
        result.put("businessExpireStart", agentInfo.getBusinessExpireStart());
        result.put("businessExpireEnd", agentInfo.getBusinessExpireEnd());
        result.put("legalName", agentInfo.getLegalName());
        result.put("contactName", agentInfo.getContactName());
        result.put("status", agentInfo.getStatus());
        result.put("address", agentInfo.getAddress());
        result.put("address", agentInfo.getAddress());
        result.put("address", agentInfo.getAddress());
        return result;
    }
}
