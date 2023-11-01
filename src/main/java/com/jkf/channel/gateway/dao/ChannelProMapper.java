package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.ChannelPro;
import com.jkf.channel.gateway.entity.ChannelProExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelProMapper {
    int countByExample(ChannelProExample example);

    int deleteByExample(ChannelProExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChannelPro record);

    int insertSelective(ChannelPro record);

    List<ChannelPro> selectByExample(ChannelProExample example);

    ChannelPro selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChannelPro record, @Param("example") ChannelProExample example);

    int updateByExample(@Param("record") ChannelPro record, @Param("example") ChannelProExample example);

    int updateByPrimaryKeySelective(ChannelPro record);

    int updateByPrimaryKey(ChannelPro record);
}