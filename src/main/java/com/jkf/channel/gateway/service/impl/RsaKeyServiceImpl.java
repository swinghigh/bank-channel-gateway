package com.jkf.channel.gateway.service.impl;

import com.jkf.channel.gateway.entity.OrgInterfceKey;
import com.jkf.channel.gateway.service.KeyService;
import com.jkf.channel.gateway.service.OrgInterfceKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiangyu
 * @date 2023/10/30 16:17
 */
@Service
public class RsaKeyServiceImpl implements KeyService {
    @Autowired
    private OrgInterfceKeyService orgInterfceKeyService;
    @Override
    public String getOrgPublicKey(String orgAppNo) {
        OrgInterfceKey orgInterfceKey=orgInterfceKeyService.getFromCache(orgAppNo);
        if(orgInterfceKey!=null){
            return orgInterfceKey.getOrgPublicKey();
        }
        return null;
    }

    @Override
    public String getPlatPrivateKey(String orgAppNo) {
        OrgInterfceKey orgInterfceKey=orgInterfceKeyService.getFromCache(orgAppNo);
        if(orgInterfceKey!=null){
            return orgInterfceKey.getPlatPrivateKey();
        }
        return null;
    }
}
