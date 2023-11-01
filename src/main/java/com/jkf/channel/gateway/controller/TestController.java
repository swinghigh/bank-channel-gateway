package com.jkf.channel.gateway.controller;

import com.jkf.channel.gateway.dao.ChannelInfoMapper;
import com.jkf.channel.gateway.entity.ChannelInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiangyu
 * @date 2023/10/27 19:02
 */
@RestController
public class TestController {
    @Resource
    private ChannelInfoMapper channelInfoMapper;

    @RequestMapping("test/find")
    public Object find(){
        ChannelInfo info= channelInfoMapper.selectByPrimaryKey(1L);
        return info;
    }
}
