package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.entity.OrgInfo;

import java.util.List;

/**
 * @author xiangyu
 * @date 2023/10/30 17:29
 */
public interface OrgInfoService {

    /**
     * 获取机构信息
     * @param orgNo
     * @return
     */
    public OrgInfo getOrgInfoFromCache(String orgNo);

    /**
     * 获取机构信息
     * @param orgNo
     * @return
     */
    public OrgInfo getOrgInfoFromDb(String orgNo);

    /**
     * 查询所有的机构
     * @return
     */
    public List<OrgInfo> findAll();
}
