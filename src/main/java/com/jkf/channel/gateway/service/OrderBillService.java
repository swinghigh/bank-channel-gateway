package com.jkf.channel.gateway.service;

import cn.hutool.core.collection.CollUtil;
import com.jkf.channel.gateway.dao.OrderBillMapper;
import com.jkf.channel.gateway.entity.OrderBill;
import com.jkf.channel.gateway.entity.OrderBillExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderBillService {

    @Resource
    private OrderBillMapper orderBillMapper;


    public OrderBill selectByChannelOrderNo(String channelOrderNo) {
        OrderBillExample example = new OrderBillExample();
        OrderBillExample.Criteria criteria = example.createCriteria();
        criteria.andChannelOrderNoEqualTo(channelOrderNo);
        List<OrderBill> orderBills = orderBillMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(orderBills)) {
            return orderBills.get(0);
        } else {
            return null;
        }
    }

    public int insert(OrderBill orderBill) {

        return orderBillMapper.insert(orderBill);
    }

}
