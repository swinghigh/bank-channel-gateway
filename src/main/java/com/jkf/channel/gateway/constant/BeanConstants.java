package com.jkf.channel.gateway.constant;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.jkf.channel.gateway.entity.OrgInfo;
import com.jkf.channel.gateway.entity.OrgInterfceKey;
import com.jkf.channel.gateway.handler.IOpenHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiangyu
 * @date 2023/10/30 17:38
 */
public class BeanConstants {
    //存放处理器的集合
    public static Map<String, IOpenHandler> handlerMap=new ConcurrentHashMap<>();
    //存放机构信息的集合
    public static Map<String, OrgInfo> orgMap=new ConcurrentHashMap<>();
    //存放密钥的集合
    public static Map<String, OrgInterfceKey> orgKeyMap=new ConcurrentHashMap<>();
    //存放机构权限的集合
    public static Set<String>  orgSet=new ConcurrentHashSet<>();
}
