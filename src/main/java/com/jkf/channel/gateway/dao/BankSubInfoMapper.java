package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.BankSubInfo;
import com.jkf.channel.gateway.entity.BankSubInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BankSubInfoMapper {
    int countByExample(BankSubInfoExample example);

    int deleteByExample(BankSubInfoExample example);

    int deleteByPrimaryKey(String branchBankNumber);

    int insert(BankSubInfo record);

    int insertSelective(BankSubInfo record);

    List<BankSubInfo> selectByExample(BankSubInfoExample example);

    BankSubInfo selectByPrimaryKey(String branchBankNumber);

    int updateByExampleSelective(@Param("record") BankSubInfo record, @Param("example") BankSubInfoExample example);

    int updateByExample(@Param("record") BankSubInfo record, @Param("example") BankSubInfoExample example);

    int updateByPrimaryKeySelective(BankSubInfo record);

    int updateByPrimaryKey(BankSubInfo record);
}