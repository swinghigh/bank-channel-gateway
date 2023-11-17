package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.MchUserInfoMapper;
import com.jkf.channel.gateway.entity.MchUserInfo;
import com.jkf.channel.gateway.entity.MchUserInfoExample;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AESUtil;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/17 14:50
 */
@Service
public class UserEditHandler implements IOpenHandler {
    @Resource
    private MchUserInfoMapper mchUserInfoMapper;
    @Override
    public String getMethod() {
        return OpenMethodEnum.USER_EDIT.getMethod();
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
        if(!StringUtils.isEmpty(jsonObject.getString("userName"))){
            mchUserInfo.setUserName(jsonObject.getString("userName"));
        }
        if(!StringUtils.isEmpty(jsonObject.getString("userNick"))) {
            mchUserInfo.setUserNick(jsonObject.getString("userNick"));
        }
        if(!StringUtils.isEmpty(jsonObject.getString("userPhone"))) {
            mchUserInfo.setUserPhone(jsonObject.getString("userPhone"));
        }
        if(!StringUtils.isEmpty(jsonObject.getString("userPhone"))) {
            mchUserInfo.setUserLogin(jsonObject.getString("userPhone"));
        }
        if(!StringUtils.isEmpty(jsonObject.getString("userPassword"))) {
            mchUserInfo.setUserPassword(AESUtil.encrypt(jsonObject.getString("userPassword"), AESUtil.key));
        }
        if(!StringUtils.isEmpty(jsonObject.getString("userEmail"))) {
            mchUserInfo.setUserEmail(jsonObject.getString("userEmail"));
        }
        mchUserInfo.setUpdateId(0L);
        mchUserInfo.setUpdateTime(new Date());
        mchUserInfoMapper.updateByPrimaryKeySelective(mchUserInfo);
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "修改成功");
        result.put("userId", mchUserInfo.getId());
        return result;
    }
}
