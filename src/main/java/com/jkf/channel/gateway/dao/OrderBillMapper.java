package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.OrderBill;
import com.jkf.channel.gateway.entity.OrderBillExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderBillMapper {
    int countByExample(OrderBillExample example);

    int deleteByExample(OrderBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderBill record);

    int insertSelective(OrderBill record);

    List<OrderBill> selectByExample(OrderBillExample example);

    OrderBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderBill record, @Param("example") OrderBillExample example);

    int updateByExample(@Param("record") OrderBill record, @Param("example") OrderBillExample example);

    int updateByPrimaryKeySelective(OrderBill record);

    int updateByPrimaryKey(OrderBill record);
}