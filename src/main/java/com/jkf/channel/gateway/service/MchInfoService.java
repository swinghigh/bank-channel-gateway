package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.dao.MchInfoMapper;
import com.jkf.channel.gateway.entity.MchInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MchInfoService {

    @Resource
    private MchInfoMapper mchInfoMapper;

    public MchInfo selectByPrimaryKey(Long id) {
        return mchInfoMapper.selectByPrimaryKey(id);
    }
}
