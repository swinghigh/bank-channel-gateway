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

    public OrderInfo selectBySerial(String serial){
        OrderInfoExample example=new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andSerialEqualTo(serial);

        List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(orderInfos)){
            return orderInfos.get(0);
        }else {
            return null;
        }
    }

    /**
     * 通过渠道订单号（在信联唯一），查订单
     * @param channelOrderNo
     * @return
     */
    public OrderInfo selectByChannelOrderNo(String channelOrderNo){
        OrderInfoExample example=new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andChannelOrderNoEqualTo(channelOrderNo);

        List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(orderInfos)){
            return orderInfos.get(0);
        }else {
            return null;
        }
    }

    /**
     * 根据
     * @param orderInfo
     * @return
     */
    public int updateByPrimaryKeySelective(OrderInfo orderInfo){
        return orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
    }

}
