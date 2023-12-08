package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.*;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AESUtil;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.DateUtil;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author xiangyu
 * @date 2023/12/8 14:39
 */
@Service
public class AgentDrawHandler  implements IOpenHandler {
    @Resource
    private OrderDrawMapper orderDrawMapper;
    @Resource
    private AgentInfoMapper agentInfoMapper;
    @Resource
    private VirtualAccountMapper virtualAccountMapper;
    @Resource
    private SysConfigMapper sysConfigMapper;
    @Resource
    private VirtualAccountDetailMapper virtualAccountDetailMapper;

    @Override
    public String getMethod() {
        return OpenMethodEnum.AGENT_DRAW.getMethod();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(),"所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outSerial"), ErrorCode.PARAM_ERROR.getErrorCode(),"outSerial为空");
        AssertUtils.customHasLength(jsonObject.getString("amount"), ErrorCode.PARAM_ERROR.getErrorCode(),"amount为空");
        try{
            jsonObject.getLong("amount");
        }catch (Exception e){
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),"金额格式不对");
        }
        OrderDrawExample example=new OrderDrawExample();
        example.createCriteria().andOrgIdEqualTo(jsonObject.getLong("orgId"))
             .andOutSerialEqualTo(jsonObject.getString("outSerial"));
        List<OrderDraw> orderDrawList=orderDrawMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(orderDrawList)){
            throw new BusinessException(ErrorCode.HAS_EXIT.getErrorCode(),"outSerial已经存在,请调用查询接口查询状态");
        }
        AssertUtils.customHasLength(jsonObject.getString("agentId"), ErrorCode.PARAM_ERROR.getErrorCode(),"agentId为空");
        AgentInfoExample agentInfoExample=new AgentInfoExample();
        List<AgentInfo> agentInfos=agentInfoMapper.selectByExample(agentInfoExample);
        AssertUtils.collectIsEmpty(agentInfos,ErrorCode.HAS_EXIT.getErrorCode(),"代理商不存在");
        AgentInfo agentInfo=agentInfos.get(0);
        //查账户
        VirtualAccount virtualAccount=virtualAccountMapper.selectByLock(agentInfo.getVirtualNo());
        AssertUtils.customNotNull(virtualAccount,ErrorCode.HAS_NOT_EXIT.getErrorCode(),"账户不存在");

        SysConfigExample sysConfigExample=new SysConfigExample();
        sysConfigExample.createCriteria().andConfigKeyEqualTo("drawRate");
        List<SysConfig> sysConfigsRate=sysConfigMapper.selectByExample(sysConfigExample);
        sysConfigExample=new SysConfigExample();
        sysConfigExample.createCriteria().andConfigKeyEqualTo("drawCostOne");
        List<SysConfig> sysConfigsCost=sysConfigMapper.selectByExample(sysConfigExample);
        String  rate="0";
        Long charge=0L;//手续费
        if(!CollectionUtils.isEmpty(sysConfigsRate)){
            rate=sysConfigsRate.get(0).getConfigValue();
        }
        charge=new BigDecimal(charge).multiply(new BigDecimal(rate)).longValue();
        Long one=0L;//单笔
        if(!CollectionUtils.isEmpty(sysConfigsCost)){
            one=Long.parseLong(sysConfigsCost.get(0).getConfigValue());
        }
        Long totalAmount=jsonObject.getLong("amount")+charge+one;
        if(totalAmount>Long.parseLong(virtualAccount.getUseAmount())){
            throw new BusinessException(ErrorCode.BLANCE_NOT_ENOUGH.getErrorCode(),"余额不足");
        }
        String drawSerNo= "D"+(1000000000000000L+sysConfigMapper.getSeq("draw_no"));
        //先存入记录,扣除余额,或者进入冻结金额,成功后在减去余额,目前采用直接扣减余额
        String accountAmountPre=virtualAccount.getUseAmount();
        virtualAccount.setUseAmount((Long.parseLong(virtualAccount.getUseAmount())-totalAmount)+"");
        virtualAccount.setEncryAmount(AESUtil.encrypt(virtualAccount.getUseAmount(), AESUtil.key));
        virtualAccount.setUpdateTime(new Date());
        virtualAccountMapper.updateByPrimaryKeySelective(virtualAccount);
        //添加一笔账户记账流水
        VirtualAccountDetail virtualAccountDetail=new VirtualAccountDetail();
        virtualAccountDetail.setVirtualNo(virtualAccount.getVirtualNo());
        virtualAccountDetail.setIsAdd("out");
        virtualAccountDetail.setActType("1");
        virtualAccountDetail.setAmount(totalAmount+"");
        virtualAccountDetail.setCharge("0");
        virtualAccountDetail.setFinalAmount(virtualAccount.getUseAmount());
        virtualAccountDetail.setRemark("服务商提现");
        virtualAccountDetail.setActDate(DateUtil.getFormat(new Date(),"yyyy-MM-dd"));
        virtualAccountDetail.setSerial(drawSerNo);
        virtualAccountDetail.setAddBlance("0");
        virtualAccountDetail.setAddName("机构请求");
        virtualAccountDetail.setCreateTime(new Date());
        virtualAccountDetailMapper.insertSelective(virtualAccountDetail);
        //添加一笔提现记录
        OrderDraw record=new OrderDraw();
        record.setOutSerial(jsonObject.getString("outSerial"));
        record.setOrgId(jsonObject.getLong("orgId"));
        record.setSerial(drawSerNo);
        record.setVirtualNo(virtualAccount.getVirtualNo());
        record.setProfitOrg(agentInfo.getId()+"");
        record.setProfitOrgType("2");
        record.setProfitOrgName(agentInfo.getAgentName());
        record.setDrawAmount(jsonObject.getLong("amount"));
        record.setDrawChargeAmount(charge+one);
        record.setChargeType("3");
        record.setChargeCostRate(rate);
        record.setChargeCostAmount(one);
        record.setVirtualAmountPre(Long.parseLong(accountAmountPre));
        record.setVirtualAmountFinish(Long.parseLong(virtualAccount.getUseAmount()));
        record.setStatus("0");
        record.setRemark(jsonObject.getString("remark"));
        record.setVirtualCustomer("1");
        record.setCreateTime(new Date());
        record.setChannelBillStatus("0");
        orderDrawMapper.insertSelective(record);
        //todo 通道处理中
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.CHECK_ING.getErrorCode(), "通道申请中");
        result.put("serial", record.getSerial());
        result.put("status", "3");
        return result;
    }
}
