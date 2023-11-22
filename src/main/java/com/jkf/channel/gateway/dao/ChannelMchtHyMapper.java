package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.ChannelMchtHy;
import com.jkf.channel.gateway.entity.ChannelMchtHyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChannelMchtHyMapper {
    int countByExample(ChannelMchtHyExample example);

    int deleteByExample(ChannelMchtHyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChannelMchtHy record);

    int insertSelective(ChannelMchtHy record);

    List<ChannelMchtHy> selectByExample(ChannelMchtHyExample example);

    ChannelMchtHy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChannelMchtHy record, @Param("example") ChannelMchtHyExample example);

    int updateByExample(@Param("record") ChannelMchtHy record, @Param("example") ChannelMchtHyExample example);

    int updateByPrimaryKeySelective(ChannelMchtHy record);

    int updateByPrimaryKey(ChannelMchtHy record);
}