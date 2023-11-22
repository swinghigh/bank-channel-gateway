package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.entity.OrgInfo;

/**
 * @author xiangyu
 * @date 2023/10/30 16:14
 */
public interface KeyService {
    /**
     * 获取机构的公钥
     * @return
     */
    public String getOrgPublicKey(String orgAppNo);

    /**
     * 获取平台的私钥
     * @param orgAppNo
     * @return
     */
    public String getPlatPrivateKey(String orgAppNo);
}
