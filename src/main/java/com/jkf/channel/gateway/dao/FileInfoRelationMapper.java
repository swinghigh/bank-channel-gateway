package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.FileInfoRelation;
import com.jkf.channel.gateway.entity.FileInfoRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileInfoRelationMapper {
    int countByExample(FileInfoRelationExample example);

    int deleteByExample(FileInfoRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileInfoRelation record);

    int insertSelective(FileInfoRelation record);

    List<FileInfoRelation> selectByExample(FileInfoRelationExample example);

    FileInfoRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileInfoRelation record, @Param("example") FileInfoRelationExample example);

    int updateByExample(@Param("record") FileInfoRelation record, @Param("example") FileInfoRelationExample example);

    int updateByPrimaryKeySelective(FileInfoRelation record);

    int updateByPrimaryKey(FileInfoRelation record);
}