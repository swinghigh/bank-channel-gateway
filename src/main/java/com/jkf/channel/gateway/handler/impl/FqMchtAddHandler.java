package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.channel.IHyService;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.AgentInfoMapper;
import com.jkf.channel.gateway.dao.AreaUnionMapper;
import com.jkf.channel.gateway.dao.MchInfoMapper;
import com.jkf.channel.gateway.dao.MchUserInfoMapper;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AESUtil;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.MchtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 分期商户开户
 *
 * @author xiangyu
 * @date 2023/11/17 19:07
 */
@Service
public class FqMchtAddHandler implements IOpenHandler {
    @Resource
    private AgentInfoMapper agentInfoMapper;
    @Resource
    private MchUserInfoMapper mchUserInfoMapper;
    @Resource
    private MchInfoMapper mchInfoMapper;
    @Resource
    private AreaUnionMapper areaUnionMapper;
    @Autowired
    private IHyService hyService;

    @Override
    public String getMethod() {
        return OpenMethodEnum.FQ_MCHT_ADD.getMethod();
    }

    private MchInfo validate(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(), "所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outMchtNo"), ErrorCode.PARAM_ERROR.getErrorCode(), "outMchtNo为空");
        //校验outMchtNo是否存在
        MchInfo mchInfo = null;
        MchInfoExample mchExample = new MchInfoExample();
        mchExample.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId")).andOutMchNoEqualTo(jsonObject.getString("outMchtNo"));
        List<MchInfo> mchInfos = mchInfoMapper.selectByExample(mchExample);
        if (mchInfos != null && mchInfos.size() > 0) {
            mchInfo = mchInfos.get(0);
            if (!mchInfo.getContactName().equals(jsonObject.getString("contactName"))) {
                throw new BusinessException(ErrorCode.HAS_EXIT.getErrorCode(), "outMchtNo已存在");
            }
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
        AssertUtils.customHasLength(jsonObject.getString("mchName"), ErrorCode.PARAM_ERROR.getErrorCode(), "mchName为空");
        AssertUtils.customHasLength(jsonObject.getString("mchShortName"), ErrorCode.PARAM_ERROR.getErrorCode(), "mchShortName为空");
        AssertUtils.customHasLength(jsonObject.getString("mchtType"), ErrorCode.PARAM_ERROR.getErrorCode(), "mchtType为空");
        AssertUtils.customHasLength(jsonObject.getString("contactName"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactName为空");
        AssertUtils.customHasLength(jsonObject.getString("contactCertNo"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactCertNo为空");
        AssertUtils.customHasLength(jsonObject.getString("contactCertType"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactCertType为空");
        AssertUtils.customHasLength(jsonObject.getString("contactExpireStart"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactExpireStart为空");
        AssertUtils.customHasLength(jsonObject.getString("contactExpireEnd"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactExpireEnd为空");
        AssertUtils.customHasLength(jsonObject.getString("contactPhone"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactPhone为空");
        AssertUtils.customHasLength(jsonObject.getString("proviceCode"), ErrorCode.PARAM_ERROR.getErrorCode(), "proviceCode为空");
        AssertUtils.customHasLength(jsonObject.getString("cityCode"), ErrorCode.PARAM_ERROR.getErrorCode(), "cityCode为空");
        AssertUtils.customHasLength(jsonObject.getString("countryCode"), ErrorCode.PARAM_ERROR.getErrorCode(), "countryCode为空");
        AssertUtils.customHasLength(jsonObject.getString("address"), ErrorCode.PARAM_ERROR.getErrorCode(), "address为空");
        AssertUtils.customHasLength(jsonObject.getString("settleCycle"), ErrorCode.PARAM_ERROR.getErrorCode(), "settleCycle为空");
        if ("1".equals(jsonObject.getString("mchtType"))) {
            AssertUtils.customHasLength(jsonObject.getString("legalPhone"), ErrorCode.PARAM_ERROR.getErrorCode(), "legalPhone为空");
            AssertUtils.customHasLength(jsonObject.getString("businessLicense"), ErrorCode.PARAM_ERROR.getErrorCode(), "businessLicense为空");
            AssertUtils.customHasLength(jsonObject.getString("businessExpireStart"), ErrorCode.PARAM_ERROR.getErrorCode(), "businessExpireStart为空");
            AssertUtils.customHasLength(jsonObject.getString("businessExpireEnd"), ErrorCode.PARAM_ERROR.getErrorCode(), "businessExpireEnd为空");
            AssertUtils.customHasLength(jsonObject.getString("enterpriseScale"), ErrorCode.PARAM_ERROR.getErrorCode(), "enterpriseScale为空");
//            AssertUtils.customHasLength(jsonObject.getString("corEmail"), ErrorCode.PARAM_ERROR.getErrorCode(), "corEmail为空");
            AssertUtils.customHasLength(jsonObject.getString("enterpriseCategory"), ErrorCode.PARAM_ERROR.getErrorCode(), "enterpriseCategory为空");
        }
        JSONObject accountInfo = jsonObject.getJSONObject("accountInfo");
        AssertUtils.customNotNull(accountInfo, ErrorCode.PARAM_ERROR.getErrorCode(), "accountInfo信息为空");
        AssertUtils.customHasLength(accountInfo.getString("bankAccountName"), ErrorCode.PARAM_ERROR.getErrorCode(), "bankAccountName为空");
        AssertUtils.customHasLength(accountInfo.getString("bankAccount"), ErrorCode.PARAM_ERROR.getErrorCode(), "bankAccount为空");
        if (StringUtils.isEmpty(accountInfo.getString("settlementCardNum")) && StringUtils.isEmpty(accountInfo.getString("acctOpenBankName"))) {
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "settlementCardNum与acctOpenBankName不能同时为空");
        }
        if ("3".equals(jsonObject.getString("mchtType"))) {
            AssertUtils.customHasLength(accountInfo.getString("contactTel"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactTel为空");
        }
        //查询省市区的名称
        AreaUnionExample addressExample = new AreaUnionExample();
        addressExample.createCriteria().andCountyNoEqualTo(jsonObject.getString("countryCode"));
        List<AreaUnion> areaUnions = areaUnionMapper.selectByExample(addressExample);
        AssertUtils.collectIsEmpty(areaUnions, ErrorCode.PARAM_ERROR.getErrorCode(), "传入的区县编码错误");
        AreaUnion areaUnion = areaUnions.get(0);
        String addressName = areaUnion.getStateNm() + "," + areaUnion.getCityNm() + "," + areaUnion.getCountyNm();
        jsonObject.put("addressName", addressName);
        AssertUtils.customHasLength(jsonObject.getString("contactEmail"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactEmail为空");
        return mchInfo;
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
        record.setUserName(jsonObject.getString("contactName"));
        record.setUserNick(jsonObject.getString("contactName"));
        record.setUserPhone(jsonObject.getString("contactPhone"));
        record.setUserLogin(mchInfo.getMchNo());
        record.setUserPassword(AESUtil.encrypt("123456", AESUtil.key));
        record.setUserEmail(jsonObject.getString("contactEmail"));
        record.setStatus("1");
        record.setCreateId(0L);
        record.setCreateTime(new Date());
        record.setMchId(mchInfo.getId());
        mchUserInfoMapper.insertSelective(record);
        record.setUserNo("U" + 1000000 + record.getId());
        mchUserInfoMapper.updateByPrimaryKeySelective(record);
        return record;
    }

    @Override
    @Transactional
    public Map<String, Object> handler(JSONObject jsonObject) {
        MchInfo oldMchtInfo = validate(jsonObject);
        if (oldMchtInfo == null) {
            //本地保存资料
            MchInfo mchInfo = MchtUtils.build(jsonObject);
            mchInfo.setMchStatus("2");
            mchInfo.setMchSource("1");
            mchInfo.setCreateId(0L);
            mchInfo.setCreateTime(new Date());
            mchInfoMapper.insertSelective(mchInfo);
            mchInfo.setMchNo("M" + (10000000 + mchInfo.getId()));
            //创建一个默认的商户登录用户
            MchUserInfo defaultUser = addMchDefaultUser(jsonObject, mchInfo);
            if (StringUtils.isEmpty(jsonObject.getString("userId"))) {
                jsonObject.put("userId", defaultUser.getId());
                mchInfo.setUserAdminId(defaultUser.getId());
            }
            mchInfoMapper.updateByPrimaryKey(mchInfo);
            oldMchtInfo = mchInfo;
        } else {
            //已经存在

        }
        jsonObject.put("mchNo", oldMchtInfo.getMchNo());
        jsonObject.put("mchId", oldMchtInfo.getId());
        Map<String, Object> result = hyService.register(jsonObject);
        if (ErrorCode.SUCCESS.getErrorCode().equals(result.get(KeyConstants.RESULT_CODE))) {
            //修改成功
            MchInfo mchInfoUpdate = new MchInfo();
            if (oldMchtInfo != null) {
                mchInfoUpdate = MchtUtils.buildEdit(jsonObject);
            }
            mchInfoUpdate.setUpdateId(0L);
            mchInfoUpdate.setUpdateTime(new Date());
            mchInfoUpdate.setId(oldMchtInfo.getId());
            mchInfoUpdate.setMchStatus("0");
            mchInfoMapper.updateByPrimaryKeySelective(mchInfoUpdate);
        }
        //调用火眼的分期接口
        result.put("mchId", oldMchtInfo.getId());
        result.put("mchNo", oldMchtInfo.getMchNo());
        return result;
    }
}
