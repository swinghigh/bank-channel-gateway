package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.channel.xinUnion.IXlService;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.MchInfoMapper;
import com.jkf.channel.gateway.entity.MchInfo;
import com.jkf.channel.gateway.entity.MchInfoExample;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AssertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 信联商户入网状态查询
 * @author xiangyu
 * @date 2023/12/4 17:21
 */
@Slf4j
@Service
public class XlMchtQueryHandler implements IOpenHandler {

    @Autowired
    private IXlService xlService;
    @Resource
    private MchInfoMapper mchInfoMapper;
    @Override
    public String getMethod() {
        return OpenMethodEnum.XL_MCHT_QUERY.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(), "所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outMchtNo"), ErrorCode.PARAM_ERROR.getErrorCode(), "outMchtNo为空");
        MchInfoExample mchExample = new MchInfoExample();
        mchExample.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId")).andOutMchNoEqualTo(jsonObject.getString("outMchtNo"));
        List<MchInfo> mchInfos = mchInfoMapper.selectByExample(mchExample);
        if(mchInfos==null||mchInfos.size()==0){
            throw new BusinessException(ErrorCode.HAS_NOT_EXIT.getErrorCode(),"商户不存在");
        }
        Map<String, Object> result=xlService.queryStatus(jsonObject);
        return result;
    }
}
