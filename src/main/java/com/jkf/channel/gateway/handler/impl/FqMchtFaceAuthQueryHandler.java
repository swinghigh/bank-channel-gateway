package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.channel.IHyService;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.MchInfoMapper;
import com.jkf.channel.gateway.entity.MchInfo;
import com.jkf.channel.gateway.entity.MchInfoExample;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/21 18:36
 */
@Service
public class FqMchtFaceAuthQueryHandler implements IOpenHandler {
    @Resource
    private MchInfoMapper mchInfoMapper;
    @Autowired
    private IHyService hyService;
    @Override
    public String getMethod() {
        return OpenMethodEnum.FQ_MCHT_FACE_AUTH_QUERY.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(), "所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("mchNo"), ErrorCode.PARAM_ERROR.getErrorCode(), "mchNo为空");
        AssertUtils.customHasLength(jsonObject.getString("token"), ErrorCode.PARAM_ERROR.getErrorCode(), "token为空");
        MchInfoExample mchExample = new MchInfoExample();
        mchExample.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId")).andMchNoEqualTo(jsonObject.getString("mchNo"));
        List<MchInfo> mchInfos = mchInfoMapper.selectByExample(mchExample);
        AssertUtils.collectIsEmpty(mchInfos, ErrorCode.HAS_NOT_EXIT.getErrorCode(), "商户不存在");
        MchInfo mchInfo = mchInfos.get(0);
        jsonObject.put("mchNo", mchInfo.getMchNo());
        jsonObject.put("mchId", mchInfo.getId());
        return hyService.authTokenQuery(jsonObject);
    }
}
