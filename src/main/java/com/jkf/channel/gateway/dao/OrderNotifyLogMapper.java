package com.jkf.channel.gateway.dao;

import com.jkf.channel.gateway.entity.OrderNotifyLog;
import com.jkf.channel.gateway.entity.OrderNotifyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderNotifyLogMapper {
    int countByExample(OrderNotifyLogExample example);

    int deleteByExample(OrderNotifyLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderNotifyLog record);

    int insertSelective(OrderNotifyLog record);

    List<OrderNotifyLog> selectByExample(OrderNotifyLogExample example);

    OrderNotifyLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderNotifyLog record, @Param("example") OrderNotifyLogExample example);

    int updateByExample(@Param("record") OrderNotifyLog record, @Param("example") OrderNotifyLogExample example);

    int updateByPrimaryKeySelective(OrderNotifyLog record);

    int updateByPrimaryKey(OrderNotifyLog record);
}