package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.OrgInterfacePermission;
import com.jkf.channel.gateway.entity.OrgInterfacePermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrgInterfacePermissionMapper {
    int countByExample(OrgInterfacePermissionExample example);

    int deleteByExample(OrgInterfacePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgInterfacePermission record);

    int insertSelective(OrgInterfacePermission record);

    List<OrgInterfacePermission> selectByExample(OrgInterfacePermissionExample example);

    OrgInterfacePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgInterfacePermission record, @Param("example") OrgInterfacePermissionExample example);

    int updateByExample(@Param("record") OrgInterfacePermission record, @Param("example") OrgInterfacePermissionExample example);

    int updateByPrimaryKeySelective(OrgInterfacePermission record);

    int updateByPrimaryKey(OrgInterfacePermission record);

    OrgInterfacePermission selectByOrgNoAndInterfaeCode(@Param("orgAppNo")String orgAppNo,@Param("interfaceCode")String interfaceCode);

    List<OrgInterfacePermission> selectAll();
}