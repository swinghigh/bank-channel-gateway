package com.jkf.channel.gateway.handler;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.jkf.channel.gateway.constant.BeanConstants;
import com.jkf.channel.gateway.entity.OrgInfo;
import com.jkf.channel.gateway.entity.OrgInterfacePermission;
import com.jkf.channel.gateway.entity.OrgInterfceKey;
import com.jkf.channel.gateway.service.OrgInfoService;
import com.jkf.channel.gateway.service.OrgInterfceKeyService;
import com.jkf.channel.gateway.service.OrgPermissionService;
import com.jkf.channel.gateway.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author xiangyu
 * @date 2023/10/30 16:59
 */
@Service
public class SystemInitService {

    @Autowired
    private List<IOpenHandler> openHandlerList;
    @Autowired
    private OrgInfoService orgInfoService;
    @Autowired
    private OrgInterfceKeyService orgInterfceKeyService;
    @Autowired
    private OrgPermissionService orgPermissionService;
    @Resource
    private RedisTemplate redisTemplate;
    @PostConstruct
    private void init(){
        if(!CollectionUtils.isEmpty(openHandlerList)){
            BeanConstants.handlerMap =openHandlerList.stream().collect(Collectors.toMap(IOpenHandler::getMethod, v -> v));
        }
        //加载信息
        reflush();
        RedisUtil.setRedisTemplate(redisTemplate);
    }
    public static IOpenHandler getHandlerByMethod(String method){
        return BeanConstants.handlerMap.get(method);
    }

    /**
     * 刷新系统常量
     */
    public void reflush(){
        List<OrgInfo> orgInfos=orgInfoService.findAll();
        if(!CollectionUtils.isEmpty(orgInfos)){
            BeanConstants.orgMap =orgInfos.stream().collect(Collectors.toMap(OrgInfo::getOrgNo,orgInfo->orgInfo,  (key1 , key2) -> key1 ));
        }else{
            BeanConstants.orgMap=new ConcurrentHashMap<>();
        }
        //加载机构密钥
        List<OrgInterfceKey> orgInterfceKeys=orgInterfceKeyService.findAll();
        if(!CollectionUtils.isEmpty(orgInterfceKeys)){
            BeanConstants.orgKeyMap =orgInterfceKeys.stream().collect(Collectors.toMap(OrgInterfceKey::getOrgAppNo,orgInterfceKey->orgInterfceKey,  (key1 , key2) -> key1 ));
        }else {
            BeanConstants.orgKeyMap =new ConcurrentHashMap<>();
        }
        //加载机构权限
        List<OrgInterfacePermission> interfacePermissions= orgPermissionService.selectAll();
        if(!CollectionUtils.isEmpty(interfacePermissions)){
            BeanConstants.orgSet =interfacePermissions.stream().map(obj->obj.getOrgAppNo()+"-"+obj.getInterfaceCode()).collect(Collectors.toSet());
        }else{
            BeanConstants.orgSet =new ConcurrentHashSet<>();
        }
    }
}
