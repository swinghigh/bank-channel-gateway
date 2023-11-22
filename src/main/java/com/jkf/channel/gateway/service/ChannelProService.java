package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.dao.ChannelProMapper;
import com.jkf.channel.gateway.entity.ChannelPro;
import com.jkf.channel.gateway.entity.ChannelProExample;
import com.jkf.channel.gateway.entity.OrgInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiangyu
 * @date 2023/11/20 20:24
 */
@Service
public class ChannelProService {
    @Resource
    private ChannelProMapper channelProMapper;

    public Map<String,String> findProByChannelId(Long channelId){
        ChannelProExample example=new ChannelProExample();
        example.createCriteria().andChannelIdEqualTo(channelId);
        List<ChannelPro> proList=channelProMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(proList)){
            return new HashMap<>(1);
        }
        Map<String,String> map=proList.stream().collect(Collectors.toMap(ChannelPro::getKeyName, ChannelPro::getKeyValue,  (key1 , key2) -> key1 ));
        return map;
    }
}
