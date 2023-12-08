package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.ProfitDetail;
import com.jkf.channel.gateway.entity.ProfitDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProfitDetailMapper {
    int countByExample(ProfitDetailExample example);

    int deleteByExample(ProfitDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProfitDetail record);

    int insertSelective(ProfitDetail record);

    List<ProfitDetail> selectByExample(ProfitDetailExample example);

    ProfitDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProfitDetail record, @Param("example") ProfitDetailExample example);

    int updateByExample(@Param("record") ProfitDetail record, @Param("example") ProfitDetailExample example);

    int updateByPrimaryKeySelective(ProfitDetail record);

    int updateByPrimaryKey(ProfitDetail record);
}