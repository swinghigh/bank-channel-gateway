package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.AgentInfo;
import com.jkf.channel.gateway.entity.AgentInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AgentInfoMapper {
    int countByExample(AgentInfoExample example);

    int deleteByExample(AgentInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AgentInfo record);

    int insertSelective(AgentInfo record);

    List<AgentInfo> selectByExample(AgentInfoExample example);

    AgentInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AgentInfo record, @Param("example") AgentInfoExample example);

    int updateByExample(@Param("record") AgentInfo record, @Param("example") AgentInfoExample example);

    int updateByPrimaryKeySelective(AgentInfo record);

    int updateByPrimaryKey(AgentInfo record);
}