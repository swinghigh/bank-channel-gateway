package com.jkf.channel.gateway.service.impl;

import com.jkf.channel.gateway.constant.BeanConstants;
import com.jkf.channel.gateway.dao.OrgInterfacePermissionMapper;
import com.jkf.channel.gateway.entity.OrgInterfacePermission;
import com.jkf.channel.gateway.service.OrgPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiangyu
 * @date 2023/10/30 16:33
 */
@Service
@Slf4j
public class OrgPermissionServiceImpl implements OrgPermissionService {
    @Resource
    private OrgInterfacePermissionMapper orgInterfacePermissionMapper;
    @Override
    public boolean validateMethod(String orgAppNo, String method) {
        log.info("机构{}-方法{}", orgAppNo, method);
        String key=orgAppNo+"-"+method;
        if(BeanConstants.orgSet.contains(key)){
            return true;
        }
        //从数据库查询
        if(findOne( orgAppNo,  method)!=null){
            BeanConstants.orgSet.add(key);
            return true;
        }
        return false;
    }

    public OrgInterfacePermission findOne(String orgAppNo, String method){
       return orgInterfacePermissionMapper.selectByOrgNoAndInterfaeCode(orgAppNo,method);
    }

    @Override
    public List<OrgInterfacePermission> selectAll() {
        return orgInterfacePermissionMapper.selectAll();
    }
}
