package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.OrgInfo;
import com.jkf.channel.gateway.entity.OrgInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgInfoMapper {
    int countByExample(OrgInfoExample example);

    int deleteByExample(OrgInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgInfo record);

    int insertSelective(OrgInfo record);

    List<OrgInfo> selectByExample(OrgInfoExample example);

    OrgInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgInfo record, @Param("example") OrgInfoExample example);

    int updateByExample(@Param("record") OrgInfo record, @Param("example") OrgInfoExample example);

    int updateByPrimaryKeySelective(OrgInfo record);

    int updateByPrimaryKey(OrgInfo record);
}