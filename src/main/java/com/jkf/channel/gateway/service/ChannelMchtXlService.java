package com.jkf.channel.gateway.service;

import cn.hutool.core.collection.CollUtil;
import com.jkf.channel.gateway.dao.ChannelMchtXlMapper;
import com.jkf.channel.gateway.entity.ChannelMchtXl;
import com.jkf.channel.gateway.entity.ChannelMchtXlExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChannelMchtXlService {

    @Resource
    private ChannelMchtXlMapper channelMchtXlMapper;

    public ChannelMchtXl getByChannelMchtNo(String channelMchtNo) {
        ChannelMchtXlExample example = new ChannelMchtXlExample();
        ChannelMchtXlExample.Criteria criteria = example.createCriteria();
        criteria.andChannelMchtNoEqualTo(channelMchtNo);
        //商户状态 10-入网中，30-正常  20审核失败
        criteria.andCheckStatusEqualTo("30");
        List<ChannelMchtXl> channelMchtXls = channelMchtXlMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(channelMchtXls)){
            return  channelMchtXls.get(0);
        }else {
            return null;
        }
    }
}
