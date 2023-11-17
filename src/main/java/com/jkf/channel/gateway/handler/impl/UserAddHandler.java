package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.AgentInfoMapper;
import com.jkf.channel.gateway.dao.MchUserInfoMapper;
import com.jkf.channel.gateway.entity.MchUserInfo;
import com.jkf.channel.gateway.entity.MchUserInfoExample;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AESUtil;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/17 14:03
 */
@Service
public class UserAddHandler implements IOpenHandler {
    @Resource
    private MchUserInfoMapper mchUserInfoMapper;
    @Resource
    private AgentInfoMapper agentInfoMapper;

    @Override
    public String getMethod() {
        return OpenMethodEnum.USER_ADD.getMethod();
    }

    public void validate(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(), "所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outUserId"), ErrorCode.PARAM_ERROR.getErrorCode(), "outUserId为空");
        AssertUtils.customHasLength(jsonObject.getString("userName"), ErrorCode.PARAM_ERROR.getErrorCode(), "userName为空");
        AssertUtils.customHasLength(jsonObject.getString("userPassword"), ErrorCode.PARAM_ERROR.getErrorCode(), "userPassword为空");
        MchUserInfoExample example = new MchUserInfoExample();
        example.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId"))
                .andOutUserIdEqualTo(jsonObject.getString("outUserId"));
        int userCount = mchUserInfoMapper.countByExample(example);
        if (userCount > 0) {
            throw new BusinessException(ErrorCode.HAS_EXIT.getErrorCode(), "outUserId已经存在");
        }
        //是否判断用户手机号已经存在
        example.createCriteria().andUserPhoneEqualTo(jsonObject.getString("userPhone"));
        int userCount1 = mchUserInfoMapper.countByExample(example);
        if (userCount1 > 0) {
            throw new BusinessException(ErrorCode.PHONE_HAS_EXIT.getErrorCode(), "手机号已经注册");
        }
        if(!StringUtils.isEmpty(jsonObject.getString("pUserId"))){
            AssertUtils.customNotNull(mchUserInfoMapper.selectByPrimaryKey(jsonObject.getLong("pUserId")),ErrorCode.PARAM_ERROR.getErrorCode(), "上级用户不存在");
        }
        if(!StringUtils.isEmpty(jsonObject.getString("agentId"))){
            AssertUtils.customNotNull(agentInfoMapper.selectByPrimaryKey(jsonObject.getLong("agentId")),ErrorCode.PARAM_ERROR.getErrorCode(), "所属代理不存在");
        }
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        validate(jsonObject);
        //保存用户
        MchUserInfo record=new MchUserInfo();
        record.setOutUserId(jsonObject.getString("outUserId"));
        if(!StringUtils.isEmpty(jsonObject.getString("pUserId"))){
            record.setPUserId(Long.parseLong(jsonObject.getString("pUserId")));
        }
        if(!StringUtils.isEmpty(jsonObject.getString("agentId"))){
            record.setAgentId(jsonObject.getLong("agentId"));
        }
        record.setOrgId(jsonObject.getLong("orgId"));
        record.setUserName(jsonObject.getString("userName"));
        record.setUserNick(jsonObject.getString("userNick"));
        record.setUserPhone(jsonObject.getString("userPhone"));
        record.setUserLogin(jsonObject.getString("userPhone"));
        record.setUserPassword(AESUtil.encrypt(jsonObject.getString("userPassword"),AESUtil.key));
        record.setUserEmail(jsonObject.getString("userEmail"));
        record.setStatus("1");
        record.setCreateId(0L);
        record.setCreateTime(new Date());
        mchUserInfoMapper.insertSelective(record);
        record.setUserNo("U"+1000000+record.getId());
        mchUserInfoMapper.updateByPrimaryKeySelective(record);
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "添加成功");
        result.put("userId", record.getId());
        return result;
    }
}
