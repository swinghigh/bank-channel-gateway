package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.OrderDrawMapper;
import com.jkf.channel.gateway.entity.OrderDraw;
import com.jkf.channel.gateway.entity.OrderDrawExample;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 提现查询
 * @author xiangyu
 * @date 2023/12/8 17:47
 */
@Service
public class DrawQueryHandler implements IOpenHandler {

    @Resource
    private OrderDrawMapper orderDrawMapper;
    @Override
    public String getMethod() {
        return OpenMethodEnum.AGENT_DRAW_QUERY.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(),"所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outSerial"), ErrorCode.PARAM_ERROR.getErrorCode(),"outSerial为空");
        OrderDrawExample example=new OrderDrawExample();
        example.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId"))
                .andOutSerialEqualTo(jsonObject.getString("outSerial"));
        List<OrderDraw> orderDrawList=orderDrawMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(orderDrawList)){
            throw new BusinessException(ErrorCode.HAS_NOT_EXIT.getErrorCode(),"提现记录不存在");
        }
        OrderDraw orderDraw=orderDrawList.get(0);
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "查询成功");
        result.put("serial", orderDraw.getSerial());
        result.put("status", orderDraw.getStatus());
        result.put("amount", orderDraw.getDrawAmount());
        result.put("remark", orderDraw.getRemark());
        if("1".equals(orderDraw.getStatus())){
            result.put("channelOrderNo", orderDraw.getChannelOrderNo());
            result.put("drawTime", orderDraw.getDrawTime());
            result.put("status", orderDraw.getStatus());
            result.put("charge", orderDraw.getDrawChargeAmount());


        }
        return result;
    }
}
