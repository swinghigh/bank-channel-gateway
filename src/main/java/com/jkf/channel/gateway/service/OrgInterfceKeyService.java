package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.entity.OrgInterfceKey;

import java.util.List;

/**
 * @author xiangyu
 * @date 2023/10/30 18:00
 */
public interface OrgInterfceKeyService {

    public OrgInterfceKey getFromCache(String orgNo);

    public OrgInterfceKey getFromDb(String orgNo);

    public List<OrgInterfceKey> findAll();
}
