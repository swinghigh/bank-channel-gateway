package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.entity.OrgInterfacePermission;

import java.util.List;

/**
 * @author xiangyu
 * @date 2023/10/30 16:32
 */
public interface OrgPermissionService {
    /**
     * 校验机构的权限
     * @param orgNo 机构号
     * @param method 方法
     */
    public boolean validateMethod(String orgNo,String method);

    /**
     * 查询所有
     * @return
     */
    List<OrgInterfacePermission> selectAll();
}
