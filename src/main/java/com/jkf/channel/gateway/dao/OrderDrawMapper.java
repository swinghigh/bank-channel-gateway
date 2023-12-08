package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.OrderDraw;
import com.jkf.channel.gateway.entity.OrderDrawExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDrawMapper {
    int countByExample(OrderDrawExample example);

    int deleteByExample(OrderDrawExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderDraw record);

    int insertSelective(OrderDraw record);

    List<OrderDraw> selectByExample(OrderDrawExample example);

    OrderDraw selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderDraw record, @Param("example") OrderDrawExample example);

    int updateByExample(@Param("record") OrderDraw record, @Param("example") OrderDrawExample example);

    int updateByPrimaryKeySelective(OrderDraw record);

    int updateByPrimaryKey(OrderDraw record);
}