package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.channel.xinUnion.IXlService;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.AgentInfoMapper;
import com.jkf.channel.gateway.dao.MchInfoMapper;
import com.jkf.channel.gateway.dao.MchUserInfoMapper;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.service.IVirtualAccountService;
import com.jkf.channel.gateway.utils.AESUtil;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.MchtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 信联商户开通
 * @author xiangyu
 * @date 2023/12/4 14:42
 */
@Slf4j
@Service
public class XlMchtAddHandler implements IOpenHandler {

    @Resource
    private MchInfoMapper mchInfoMapper;
    @Resource
    private MchUserInfoMapper mchUserInfoMapper;
    @Resource
    private AgentInfoMapper agentInfoMapper;
    @Autowired
    private IXlService xlService;
    @Autowired
    private IVirtualAccountService virtualAccountService;
    @Override
    public String getMethod() {
        return OpenMethodEnum.XL_MCHT_ADD.getMethod();
    }

    /**
     * 校验信息
     * @param jsonObject
     * @return
     */
    private MchInfo validate(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(), "所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outMchtNo"), ErrorCode.PARAM_ERROR.getErrorCode(), "outMchtNo为空");
        AssertUtils.customHasLength(jsonObject.getString("mchName"), ErrorCode.PARAM_ERROR.getErrorCode(), "mchName为空");
        AssertUtils.customHasLength(jsonObject.getString("username"), ErrorCode.PARAM_ERROR.getErrorCode(), "username为空");
        AssertUtils.customHasLength(jsonObject.getString("loginPwd"), ErrorCode.PARAM_ERROR.getErrorCode(), "loginPwd为空");
        AssertUtils.customHasLength(jsonObject.getString("notifyUrl"), ErrorCode.PARAM_ERROR.getErrorCode(), "notifyUrl为空");
        //校验outMchtNo是否存在
        MchInfo mchInfo = null;
        MchInfoExample mchExample = new MchInfoExample();
        mchExample.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId")).andOutMchNoEqualTo(jsonObject.getString("outMchtNo"));
        List<MchInfo> mchInfos = mchInfoMapper.selectByExample(mchExample);
        if (mchInfos != null && mchInfos.size() > 0) {
            mchInfo = mchInfos.get(0);
            if(!AESUtil.encrypt(jsonObject.getString("username"),AESUtil.key).equals(mchInfo.getContactPhone())){
                throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "outMchtNo存在的商户username不一致,username不允许修改");
            }
            /*if (!mchInfo.getContactName().equals(jsonObject.getString("contactName"))) {
                throw new BusinessException(ErrorCode.HAS_EXIT.getErrorCode(), "outMchtNo已存在");
            }*/
            if (!StringUtils.isEmpty(jsonObject.getString("agentId")) && mchInfo.getAgentId() != null && Long.parseLong(jsonObject.getString("agentId")) != mchInfo.getAgentId()) {
                throw new BusinessException(ErrorCode.HAS_EXIT.getErrorCode(), "outMchtNo已存在,agentId不一致");
            }
            if (!StringUtils.isEmpty(jsonObject.getString("userId")) && mchInfo.getUserAdminId() != null && Long.parseLong(jsonObject.getString("userId")) != mchInfo.getUserAdminId()) {
                throw new BusinessException(ErrorCode.HAS_EXIT.getErrorCode(), "outMchtNo已存在,agentId不一致");
            }
        }
        AssertUtils.customHasLength(jsonObject.getString("agentId"), ErrorCode.PARAM_ERROR.getErrorCode(), "agentId为空");
        AgentInfoExample agentExample = new AgentInfoExample();
        agentExample.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId"))
                .andIdEqualTo(jsonObject.getLong("agentId"));
        int agentCount = agentInfoMapper.countByExample(agentExample);
        if (agentCount == 0) {
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "agentId不存在");
        }
        if (!StringUtils.isEmpty(jsonObject.getString("userId"))) {
            MchUserInfoExample userExample = new MchUserInfoExample();
            userExample.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId"))
                    .andIdEqualTo(jsonObject.getLong("userId"));
            int userCount = mchUserInfoMapper.countByExample(userExample);
            if (userCount == 0) {
                throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "userId不存在");
            }
        }
        return mchInfo;
    }
    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        MchInfo oldMchtInfo=validate(jsonObject);
        if(oldMchtInfo==null){
            //新的商户
            MchInfo mchInfo=new MchInfo();
            mchInfo.setOutMchNo(jsonObject.getString("outMchtNo"));
            mchInfo.setOrgId(jsonObject.getLong("orgId"));
            mchInfo.setAgentId(jsonObject.getLong("agentId"));
            if(!StringUtils.isEmpty(jsonObject.getString("userId"))){
                mchInfo.setUserAdminId(jsonObject.getLong("userId"));
            }
            mchInfo.setMchName(jsonObject.getString("mchName"));
            mchInfo.setMchShortName(jsonObject.getString("mchName"));
            mchInfo.setContactPhone(AESUtil.encrypt(jsonObject.getString("username"),AESUtil.key));
            mchInfo.setMchStatus("2");
            mchInfo.setMchSource("1");
            mchInfo.setCreateId(0L);
            mchInfo.setCreateTime(new Date());
            mchInfoMapper.insertSelective(mchInfo);
            mchInfo.setVirtualNo(virtualAccountService.createAccount("1"));
            mchInfo.setMchNo("M" + (10000000 + mchInfo.getId()));
            //创建一个默认的用户
            //创建一个默认的商户登录用户
            MchUserInfo defaultUser = addMchDefaultUser(jsonObject, mchInfo);
            if (StringUtils.isEmpty(jsonObject.getString("userId"))) {
                jsonObject.put("userId", defaultUser.getId());
                mchInfo.setUserAdminId(defaultUser.getId());
            }
            mchInfoMapper.updateByPrimaryKey(mchInfo);
            oldMchtInfo = mchInfo;
        }else{
            //已经存在的,不做任何处理

        }
        jsonObject.put("mchNo", oldMchtInfo.getMchNo());
        jsonObject.put("mchId", oldMchtInfo.getId());
        Map<String, Object> result =xlService.register(jsonObject);
        if (ErrorCode.SUCCESS.getErrorCode().equals(result.get(KeyConstants.RESULT_CODE))) {
            //开户审核中
            MchInfo mchInfoUpdate = new MchInfo();
            mchInfoUpdate.setMchName(jsonObject.getString("mchName"));
            mchInfoUpdate.setMchShortName(jsonObject.getString("mchName"));
            mchInfoUpdate.setUpdateId(0L);
            mchInfoUpdate.setUpdateTime(new Date());
            mchInfoUpdate.setId(oldMchtInfo.getId());
            mchInfoUpdate.setMchStatus("3");//审核中
            mchInfoUpdate.setChannelId((Long )result.get("channelId"));
            mchInfoMapper.updateByPrimaryKeySelective(mchInfoUpdate);
        }else if(ErrorCode.HAS_OPEN_SUCCESS.getErrorCode().equals(result.get(KeyConstants.RESULT_CODE))){
            result.put(KeyConstants.RESULT_CODE, ErrorCode.SUCCESS.getErrorCode());
            //已经入网成功过
        }
        //调用火眼的分期接口
        result.put("mchId", oldMchtInfo.getId());
        result.put("mchNo", oldMchtInfo.getMchNo());
        return result;
    }


    /**
     * 添加默认的商户的用户
     *
     * @param jsonObject
     * @param mchInfo
     * @return
     */
    private MchUserInfo addMchDefaultUser(JSONObject jsonObject, MchInfo mchInfo) {
        //默认创建一个用户
        MchUserInfo record = new MchUserInfo();
        record.setAgentId(jsonObject.getLong("agentId"));
        record.setOrgId(jsonObject.getLong("orgId"));
        record.setUserName(jsonObject.getString("username"));
        record.setUserNick(jsonObject.getString("username"));
        record.setUserPhone(AESUtil.encrypt(jsonObject.getString("username"), AESUtil.key));
        record.setUserLogin(mchInfo.getMchNo());
        record.setUserPassword(AESUtil.encrypt(jsonObject.getString("loginPwd"), AESUtil.key));
//        record.setUserEmail(jsonObject.getString("contactEmail"));
        record.setStatus("1");
        record.setCreateId(0L);
        record.setCreateTime(new Date());
        record.setMchId(mchInfo.getId());//主商户
        mchUserInfoMapper.insertSelective(record);
        record.setUserNo("U" + 1000000 + record.getId());
        mchUserInfoMapper.updateByPrimaryKeySelective(record);
        return record;
    }
}
