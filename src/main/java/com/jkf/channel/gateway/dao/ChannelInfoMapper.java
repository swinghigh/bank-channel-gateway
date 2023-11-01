package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.ChannelInfo;
import com.jkf.channel.gateway.entity.ChannelInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChannelInfoMapper {
    int countByExample(ChannelInfoExample example);

    int deleteByExample(ChannelInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChannelInfo record);

    int insertSelective(ChannelInfo record);

    List<ChannelInfo> selectByExample(ChannelInfoExample example);

    ChannelInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChannelInfo record, @Param("example") ChannelInfoExample example);

    int updateByExample(@Param("record") ChannelInfo record, @Param("example") ChannelInfoExample example);

    int updateByPrimaryKeySelective(ChannelInfo record);

    int updateByPrimaryKey(ChannelInfo record);
}