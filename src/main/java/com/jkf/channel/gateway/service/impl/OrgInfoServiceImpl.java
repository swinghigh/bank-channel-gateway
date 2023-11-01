package com.jkf.channel.gateway.service.impl;

import com.jkf.channel.gateway.constant.BeanConstants;
import com.jkf.channel.gateway.dao.OrgInfoMapper;
import com.jkf.channel.gateway.entity.OrgInfo;
import com.jkf.channel.gateway.entity.OrgInfoExample;
import com.jkf.channel.gateway.service.OrgInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiangyu
 * @date 2023/10/30 17:31
 */
@Service
public class OrgInfoServiceImpl implements OrgInfoService {
    @Resource
    private OrgInfoMapper orgInfoMapper;
    @Override
    public OrgInfo getOrgInfoFromCache(String orgNo) {
        OrgInfo orgInfo=BeanConstants.orgMap.get(orgNo);
        if(orgInfo!=null){
            return orgInfo;
        }
        orgInfo= getOrgInfoFromDb( orgNo);
        if(orgInfo!=null){
            BeanConstants.orgMap.put(orgInfo.getOrgNo(),orgInfo);
        }
        return orgInfo;
    }

    @Override
    public OrgInfo getOrgInfoFromDb(String orgNo) {
        OrgInfoExample example=new OrgInfoExample();
        example.createCriteria().andOrgNoEqualTo(orgNo);
        List<OrgInfo> orgInfos=orgInfoMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(orgInfos)){
            return orgInfos.get(0);
        }
        return null;
    }

    @Override
    public List<OrgInfo> findAll() {
        OrgInfoExample example=new OrgInfoExample();
        return  orgInfoMapper.selectByExample(example);
    }
}
