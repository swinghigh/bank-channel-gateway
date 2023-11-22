package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.ChannelMchRoute;
import com.jkf.channel.gateway.entity.ChannelMchRouteExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChannelMchRouteMapper {
    int countByExample(ChannelMchRouteExample example);

    int deleteByExample(ChannelMchRouteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChannelMchRoute record);

    int insertSelective(ChannelMchRoute record);

    List<ChannelMchRoute> selectByExample(ChannelMchRouteExample example);

    ChannelMchRoute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChannelMchRoute record, @Param("example") ChannelMchRouteExample example);

    int updateByExample(@Param("record") ChannelMchRoute record, @Param("example") ChannelMchRouteExample example);

    int updateByPrimaryKeySelective(ChannelMchRoute record);

    int updateByPrimaryKey(ChannelMchRoute record);

    List<ChannelMchRoute> selectByMchtIdAndCompanyCode(@Param("mchId") Long mchId,@Param("channelCompanyCode") String channelCompanyCode);
}