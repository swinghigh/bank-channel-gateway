package com.jkf.channel.gateway.service.impl;

import com.jkf.channel.gateway.dao.VirtualAccountMapper;
import com.jkf.channel.gateway.entity.VirtualAccount;
import com.jkf.channel.gateway.service.IVirtualAccountService;
import com.jkf.channel.gateway.utils.AESUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author xiangyu
 * @date 2023/12/5 20:32
 */
@Service
public class VirtualAccountServiceImpl implements IVirtualAccountService {
    @Resource
    private VirtualAccountMapper virtualAccountMapper;
    @Override
    @Transactional
    public String createAccount(String accountType) {
        VirtualAccount record=new VirtualAccount();
        record.setVirtualNo(System.currentTimeMillis()+"");
        record.setVirtualAccountType(accountType);
        record.setUseAmount("0");
        record.setDisUseAmount("0");
        record.setFreezeAmount("0");
        record.setEncryAmount(AESUtil.encrypt(record.getUseAmount(), AESUtil.key));
        record.setStatus("0");
        record.setCreateId(0L);
        record.setCreateTime(new Date());
        virtualAccountMapper.insertSelective(record);
        record.setVirtualNo("B"+(100000000000L+record.getId()));
        virtualAccountMapper.updateByPrimaryKeySelective(record);
        return record.getVirtualNo();
    }
}
