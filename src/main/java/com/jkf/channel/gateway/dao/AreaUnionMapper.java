package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.AreaUnion;
import com.jkf.channel.gateway.entity.AreaUnionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AreaUnionMapper {
    int countByExample(AreaUnionExample example);

    int deleteByExample(AreaUnionExample example);

    int insert(AreaUnion record);

    int insertSelective(AreaUnion record);

    List<AreaUnion> selectByExample(AreaUnionExample example);

    int updateByExampleSelective(@Param("record") AreaUnion record, @Param("example") AreaUnionExample example);

    int updateByExample(@Param("record") AreaUnion record, @Param("example") AreaUnionExample example);
}