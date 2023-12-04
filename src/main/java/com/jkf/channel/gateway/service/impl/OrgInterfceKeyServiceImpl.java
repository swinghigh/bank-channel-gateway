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
    public OrgInterfceKey getFromCache(String orgAppNo) {
        OrgInterfceKey orgInterfceKey=BeanConstants.orgKeyMap.get(orgAppNo);
        if(orgInterfceKey!=null){
            return orgInterfceKey;
        }
        orgInterfceKey=getFromDb( orgAppNo);
        if(orgInterfceKey!=null){
            BeanConstants.orgKeyMap.put(orgInterfceKey.getOrgAppNo(),orgInterfceKey);
        }
        return orgInterfceKey;
    }

    @Override
    public OrgInterfceKey getFromDb(String orgAppNo) {
        OrgInterfceKeyExample example=new OrgInterfceKeyExample();
        OrgInterfceKeyExample.Criteria criteria = example.createCriteria();
        criteria.andOrgAppNoEqualTo(orgAppNo);
        //1正常 0禁用
        criteria.andStatusEqualTo("1");
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
