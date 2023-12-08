package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.VirtualAccountDetail;
import com.jkf.channel.gateway.entity.VirtualAccountDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VirtualAccountDetailMapper {
    int countByExample(VirtualAccountDetailExample example);

    int deleteByExample(VirtualAccountDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VirtualAccountDetail record);

    int insertSelective(VirtualAccountDetail record);

    List<VirtualAccountDetail> selectByExample(VirtualAccountDetailExample example);

    VirtualAccountDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VirtualAccountDetail record, @Param("example") VirtualAccountDetailExample example);

    int updateByExample(@Param("record") VirtualAccountDetail record, @Param("example") VirtualAccountDetailExample example);

    int updateByPrimaryKeySelective(VirtualAccountDetail record);

    int updateByPrimaryKey(VirtualAccountDetail record);
}