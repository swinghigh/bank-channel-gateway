package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.channel.IHyService;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.AreaUnionMapper;
import com.jkf.channel.gateway.dao.ChannelMchRouteMapper;
import com.jkf.channel.gateway.dao.MchInfoMapper;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.MchtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 分期商户修改
 * @author xiangyu
 * @date 2023/11/17 19:08
 */
@Service
public class FqMchtEditHandler  implements IOpenHandler {
    @Resource
    private AreaUnionMapper areaUnionMapper;
    @Resource
    private MchInfoMapper mchInfoMapper;
    @Autowired
    private IHyService hyService;
    @Resource
    private ChannelMchRouteMapper channelMchRouteMapper;
    @Override
    public String getMethod() {
        return OpenMethodEnum.FQ_MCHT_EDIT.getMethod();
    }

    private MchInfo validate(JSONObject jsonObject){
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(), "所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outMchtNo"), ErrorCode.PARAM_ERROR.getErrorCode(), "outMchtNo为空");
        //校验outMchtNo是否存在
        MchInfoExample mchExample = new MchInfoExample();
        mchExample.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId")).andOutMchNoEqualTo(jsonObject.getString("outMchtNo"));
        List<MchInfo> mchInfos= mchInfoMapper.selectByExample(mchExample);
        AssertUtils.collectIsEmpty(mchInfos,ErrorCode.HAS_NOT_EXIT.getErrorCode(), "商户不存在");
        MchInfo mchInfo=mchInfos.get(0);
        AssertUtils.customHasLength(jsonObject.getString("agentId"), ErrorCode.PARAM_ERROR.getErrorCode(), "agentId为空");
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
        if("1".equals(jsonObject.getString("mchtType"))){
            AssertUtils.customHasLength(jsonObject.getString("legalPhone"), ErrorCode.PARAM_ERROR.getErrorCode(), "legalPhone为空");
            AssertUtils.customHasLength(jsonObject.getString("businessLicense"), ErrorCode.PARAM_ERROR.getErrorCode(), "businessLicense为空");
            AssertUtils.customHasLength(jsonObject.getString("businessExpireStart"), ErrorCode.PARAM_ERROR.getErrorCode(), "businessExpireStart为空");
            AssertUtils.customHasLength(jsonObject.getString("businessExpireEnd"), ErrorCode.PARAM_ERROR.getErrorCode(), "businessExpireEnd为空");
            AssertUtils.customHasLength(jsonObject.getString("enterpriseScale"), ErrorCode.PARAM_ERROR.getErrorCode(), "enterpriseScale为空");
//            AssertUtils.customHasLength(jsonObject.getString("corEmail"), ErrorCode.PARAM_ERROR.getErrorCode(), "corEmail为空");
            AssertUtils.customHasLength(jsonObject.getString("enterpriseCategory"), ErrorCode.PARAM_ERROR.getErrorCode(), "enterpriseCategory为空");
        }
        //查询省市区的名称
        AreaUnionExample addressExample=new AreaUnionExample();
        addressExample.createCriteria().andCountyNoEqualTo(jsonObject.getString("countryCode"));
        List<AreaUnion> areaUnions=areaUnionMapper.selectByExample(addressExample);
        AssertUtils.collectIsEmpty(areaUnions,ErrorCode.PARAM_ERROR.getErrorCode(),"传入的区县编码错误");
        AreaUnion areaUnion=areaUnions.get(0);
        String addressName=areaUnion.getStateNm()+","+areaUnion.getCityNm()+","+areaUnion.getCountyNm();
        jsonObject.put("addressName",addressName);
        AssertUtils.customHasLength(jsonObject.getString("contactEmail"), ErrorCode.PARAM_ERROR.getErrorCode(), "contactEmail为空");
        return mchInfo;
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        MchInfo mchInfo=validate(jsonObject);
        jsonObject.put("mchNo",mchInfo.getMchNo());
        jsonObject.put("mchId",mchInfo.getId());
        Map<String, Object> result =hyService.edit(jsonObject);
        if(ErrorCode.SUCCESS.getErrorCode().equals(result.get(KeyConstants.RESULT_CODE))){
            //修改成功
            MchInfo mchInfoUpdate= MchtUtils.buildEdit(jsonObject);
            mchInfoUpdate.setUpdateId(0L);
            mchInfoUpdate.setUpdateTime(new Date());
            mchInfoUpdate.setId(mchInfo.getId());
            mchInfoMapper.updateByPrimaryKeySelective(mchInfoUpdate);
        }
        result.put("mchId", mchInfo.getId());
        result.put("mchNo", mchInfo.getMchNo());
        return result;
    }
}
