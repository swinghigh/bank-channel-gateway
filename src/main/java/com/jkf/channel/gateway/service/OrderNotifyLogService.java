package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.dao.OrderNotifyLogMapper;
import com.jkf.channel.gateway.entity.OrderNotifyLog;
import com.jkf.channel.gateway.entity.OrderNotifyLogExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderNotifyLogService {
    @Resource
    private OrderNotifyLogMapper orderNotifyLogMapper;

    public int insert(OrderNotifyLog record) {
        return orderNotifyLogMapper.insert(record);
    }

    /**
     * 待通知的列表
     * 未通知且通知次数小于10
     * @return
     */
    public List<OrderNotifyLog> selectNeedNoticeList() {
        OrderNotifyLogExample example=new OrderNotifyLogExample();
        OrderNotifyLogExample.Criteria criteria = example.createCriteria();
        criteria.andNotifyStatusEqualTo("0");
        criteria.andNotifyCountLessThan(10);
        return orderNotifyLogMapper.selectByExample(example);
    }

    public int updateByPrimaryKeySelective(OrderNotifyLog record) {
        return orderNotifyLogMapper.updateByPrimaryKeySelective(record);
    }
}
