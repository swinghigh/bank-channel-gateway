package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.MchUserInfoMapper;
import com.jkf.channel.gateway.entity.MchUserInfo;
import com.jkf.channel.gateway.entity.MchUserInfoExample;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/17 15:07
 */
@Service
public class UserQueryHandler implements IOpenHandler {
    @Resource
    private MchUserInfoMapper mchUserInfoMapper;
    @Override
    public String getMethod() {
        return OpenMethodEnum.USER_QUERY.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(), "所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outUserId"), ErrorCode.PARAM_ERROR.getErrorCode(), "outUserId为空");
        MchUserInfoExample example = new MchUserInfoExample();
        example.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId"))
                .andOutUserIdEqualTo(jsonObject.getString("outUserId"));
        List<MchUserInfo> mchUserInfos= mchUserInfoMapper.selectByExample(example);
        AssertUtils.collectIsEmpty(mchUserInfos,ErrorCode.PARAM_ERROR.getErrorCode(),"outUserId用户不存在");
        MchUserInfo mchUserInfo=mchUserInfos.get(0);
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "查询成功");
        result.put("userId", mchUserInfo.getId());
        result.put("userName", mchUserInfo.getUserName());
        result.put("status", mchUserInfo.getStatus());
        return result;
    }
}
