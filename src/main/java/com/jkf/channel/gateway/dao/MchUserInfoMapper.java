package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.MchUserInfo;
import com.jkf.channel.gateway.entity.MchUserInfoExample;
import java.util.List;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MchUserInfoMapper {
    int countByExample(MchUserInfoExample example);

    int deleteByExample(MchUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MchUserInfo record);

    int insertSelective(MchUserInfo record);

    List<MchUserInfo> selectByExample(MchUserInfoExample example);

    MchUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MchUserInfo record, @Param("example") MchUserInfoExample example);

    int updateByExample(@Param("record") MchUserInfo record, @Param("example") MchUserInfoExample example);

    int updateByPrimaryKeySelective(MchUserInfo record);

    int updateByPrimaryKey(MchUserInfo record);
}