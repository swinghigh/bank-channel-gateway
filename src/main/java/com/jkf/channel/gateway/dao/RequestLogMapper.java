package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.RequestLog;
import com.jkf.channel.gateway.entity.RequestLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestLogMapper {
    int countByExample(RequestLogExample example);

    int deleteByExample(RequestLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RequestLog record);

    int insertSelective(RequestLog record);

    List<RequestLog> selectByExampleWithBLOBs(RequestLogExample example);

    List<RequestLog> selectByExample(RequestLogExample example);

    RequestLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RequestLog record, @Param("example") RequestLogExample example);

    int updateByExampleWithBLOBs(@Param("record") RequestLog record, @Param("example") RequestLogExample example);

    int updateByExample(@Param("record") RequestLog record, @Param("example") RequestLogExample example);

    int updateByPrimaryKeySelective(RequestLog record);

    int updateByPrimaryKeyWithBLOBs(RequestLog record);

    int updateByPrimaryKey(RequestLog record);
}