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
        //商户状态 商户状态0-正式、1-停用、2-待提交资质、3-审核中 4进件失败 5审核失败
        criteria.andCheckStatusEqualTo("0");
        List<ChannelMchtXl> channelMchtXls = channelMchtXlMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(channelMchtXls)){
            return  channelMchtXls.get(0);
        }else {
            return null;
        }
    }

    public List<ChannelMchtXl> getAll() {
        ChannelMchtXlExample example = new ChannelMchtXlExample();
        ChannelMchtXlExample.Criteria criteria = example.createCriteria();
        //商户状态 商户状态0-正式、1-停用、2-待提交资质、3-审核中 4进件失败 5审核失败
        criteria.andCheckStatusEqualTo("0");
        List<ChannelMchtXl> channelMchtXlList = channelMchtXlMapper.selectByExample(example);
        return  channelMchtXlList;

    }
}
