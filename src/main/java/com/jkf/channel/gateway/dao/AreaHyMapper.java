package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.AreaHy;
import com.jkf.channel.gateway.entity.AreaHyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AreaHyMapper {
    int countByExample(AreaHyExample example);

    int deleteByExample(AreaHyExample example);

    int insert(AreaHy record);

    int insertSelective(AreaHy record);

    List<AreaHy> selectByExample(AreaHyExample example);

    int updateByExampleSelective(@Param("record") AreaHy record, @Param("example") AreaHyExample example);

    int updateByExample(@Param("record") AreaHy record, @Param("example") AreaHyExample example);
}