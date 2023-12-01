package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.dao.OrderNotifyLogMapper;
import com.jkf.channel.gateway.entity.OrderNotifyLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderNotifyLogService {
    @Resource
    private OrderNotifyLogMapper orderNotifyLogMapper;

    public int insert(OrderNotifyLog record) {
        return orderNotifyLogMapper.insert(record);
    }
}
