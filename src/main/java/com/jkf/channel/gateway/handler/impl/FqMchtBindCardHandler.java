package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.channel.IHyService;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.MchInfoMapper;
import com.jkf.channel.gateway.entity.MchInfo;
import com.jkf.channel.gateway.entity.MchInfoExample;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AssertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 分期商户绑卡
 *
 * @author xiangyu
 * @date 2023/11/17 19:09
 */
@Service
public class FqMchtBindCardHandler implements IOpenHandler {
    @Resource
    private MchInfoMapper mchInfoMapper;
    @Autowired
    private IHyService hyService;

    @Override
    public String getMethod() {
        return OpenMethodEnum.FQ_MCHT_BIND_CARD.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(), "所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("mchNo"), ErrorCode.PARAM_ERROR.getErrorCode(), "mchNo为空");
        AssertUtils.customHasLength(jsonObject.getString("bankAccount"), ErrorCode.PARAM_ERROR.getErrorCode(), "bankAccount为空");
        AssertUtils.customHasLength(jsonObject.getString("bankAccountName"), ErrorCode.PARAM_ERROR.getErrorCode(), "bankAccountName为空");
        if (StringUtils.isEmpty(jsonObject.getString("settlementCardNum")) && StringUtils.isEmpty(jsonObject.getString("acctOpenBankName"))) {
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "settlementCardNum与acctOpenBankName同时为空");
        }
        MchInfoExample mchExample = new MchInfoExample();
        mchExample.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId")).andMchNoEqualTo(jsonObject.getString("mchNo"));
        List<MchInfo> mchInfos = mchInfoMapper.selectByExample(mchExample);
        AssertUtils.collectIsEmpty(mchInfos, ErrorCode.HAS_NOT_EXIT.getErrorCode(), "商户不存在");
        MchInfo mchInfo = mchInfos.get(0);
        jsonObject.put("mchNo", mchInfo.getMchNo());
        jsonObject.put("mchId", mchInfo.getId());
        return hyService.bindCard(jsonObject);
    }
}
