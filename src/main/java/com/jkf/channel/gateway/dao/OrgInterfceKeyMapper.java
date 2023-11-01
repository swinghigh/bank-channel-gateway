package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.OrgInterfceKey;
import com.jkf.channel.gateway.entity.OrgInterfceKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgInterfceKeyMapper {
    int countByExample(OrgInterfceKeyExample example);

    int deleteByExample(OrgInterfceKeyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgInterfceKey record);

    int insertSelective(OrgInterfceKey record);

    List<OrgInterfceKey> selectByExample(OrgInterfceKeyExample example);

    OrgInterfceKey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgInterfceKey record, @Param("example") OrgInterfceKeyExample example);

    int updateByExample(@Param("record") OrgInterfceKey record, @Param("example") OrgInterfceKeyExample example);

    int updateByPrimaryKeySelective(OrgInterfceKey record);

    int updateByPrimaryKey(OrgInterfceKey record);
}