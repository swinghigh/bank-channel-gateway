package com.jkf.channel.gateway.service.impl;

import com.jkf.channel.gateway.constant.BeanConstants;
import com.jkf.channel.gateway.dao.OrgInterfceKeyMapper;
import com.jkf.channel.gateway.entity.OrgInterfceKey;
import com.jkf.channel.gateway.entity.OrgInterfceKeyExample;
import com.jkf.channel.gateway.service.OrgInterfceKeyService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiangyu
 * @date 2023/10/30 18:03
 */
@Service
public class OrgInterfceKeyServiceImpl implements OrgInterfceKeyService {
    @Resource
    private OrgInterfceKeyMapper orgInterfceKeyMapper;
    @Override
    public OrgInterfceKey getFromCache(String orgNo) {
        OrgInterfceKey orgInterfceKey=BeanConstants.orgKeyMap.get(orgNo);
        if(orgInterfceKey!=null){
            return orgInterfceKey;
        }
        orgInterfceKey=getFromDb( orgNo);
        if(orgInterfceKey!=null){
            BeanConstants.orgKeyMap.put(orgInterfceKey.getOrgNo(),orgInterfceKey);
        }
        return orgInterfceKey;
    }

    @Override
    public OrgInterfceKey getFromDb(String orgNo) {
        OrgInterfceKeyExample example=new OrgInterfceKeyExample();
        example.createCriteria().andOrgNoEqualTo(orgNo);
        List<OrgInterfceKey> orgInterfceKeys=orgInterfceKeyMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(orgInterfceKeys)){
            return orgInterfceKeys.get(0);
        }
        return null;
    }

    @Override
    public List<OrgInterfceKey> findAll() {
        OrgInterfceKeyExample example=new OrgInterfceKeyExample();
        return  orgInterfceKeyMapper.selectByExample(example);
    }
}
