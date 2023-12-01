package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.ChannelMchtXl;
import com.jkf.channel.gateway.entity.ChannelMchtXlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMchtXlMapper {
    int countByExample(ChannelMchtXlExample example);

    int deleteByExample(ChannelMchtXlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChannelMchtXl record);

    int insertSelective(ChannelMchtXl record);

    List<ChannelMchtXl> selectByExample(ChannelMchtXlExample example);

    ChannelMchtXl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChannelMchtXl record, @Param("example") ChannelMchtXlExample example);

    int updateByExample(@Param("record") ChannelMchtXl record, @Param("example") ChannelMchtXlExample example);

    int updateByPrimaryKeySelective(ChannelMchtXl record);

    int updateByPrimaryKey(ChannelMchtXl record);
}