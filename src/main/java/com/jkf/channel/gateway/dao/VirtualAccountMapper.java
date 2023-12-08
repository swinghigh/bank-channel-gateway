package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.VirtualAccount;
import com.jkf.channel.gateway.entity.VirtualAccountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VirtualAccountMapper {
    int countByExample(VirtualAccountExample example);

    int deleteByExample(VirtualAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VirtualAccount record);

    int insertSelective(VirtualAccount record);

    List<VirtualAccount> selectByExample(VirtualAccountExample example);

    VirtualAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VirtualAccount record, @Param("example") VirtualAccountExample example);

    int updateByExample(@Param("record") VirtualAccount record, @Param("example") VirtualAccountExample example);

    int updateByPrimaryKeySelective(VirtualAccount record);

    int updateByPrimaryKey(VirtualAccount record);

    VirtualAccount selectByLock(@Param("virtualNo")String virtualNo);
}