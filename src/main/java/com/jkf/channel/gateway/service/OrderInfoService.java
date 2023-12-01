package com.jkf.channel.gateway.service;

import cn.hutool.core.collection.CollUtil;
import com.jkf.channel.gateway.dao.OrderInfoMapper;
import com.jkf.channel.gateway.entity.OrderInfo;
import com.jkf.channel.gateway.entity.OrderInfoExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    public int insert(OrderInfo orderInfo){
        return orderInfoMapper.insert(orderInfo);
    }

    public OrderInfo selectByOutSerial(String outSerial){
        OrderInfoExample example=new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOutSerialEqualTo(outSerial);

        List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(orderInfos)){
            return orderInfos.get(0);
        }else {
            return null;
        }

    }
}
