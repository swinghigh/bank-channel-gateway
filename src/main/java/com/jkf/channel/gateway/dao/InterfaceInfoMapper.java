package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.InterfaceInfo;
import com.jkf.channel.gateway.entity.InterfaceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InterfaceInfoMapper {
    int countByExample(InterfaceInfoExample example);

    int deleteByExample(InterfaceInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InterfaceInfo record);

    int insertSelective(InterfaceInfo record);

    List<InterfaceInfo> selectByExample(InterfaceInfoExample example);

    InterfaceInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InterfaceInfo record, @Param("example") InterfaceInfoExample example);

    int updateByExample(@Param("record") InterfaceInfo record, @Param("example") InterfaceInfoExample example);

    int updateByPrimaryKeySelective(InterfaceInfo record);

    int updateByPrimaryKey(InterfaceInfo record);
}