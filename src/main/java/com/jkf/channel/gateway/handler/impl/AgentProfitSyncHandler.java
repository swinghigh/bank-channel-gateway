package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.*;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.service.AgentService;
import com.jkf.channel.gateway.service.IVirtualAccountService;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.DateUtil;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author xiangyu
 * @date 2023/12/6 18:18
 */
@Service
public class AgentProfitSyncHandler implements IOpenHandler {
    @Resource
    private ProfitDetailMapper profitDetailMapper;
    @Resource
    private AgentInfoMapper agentInfoMapper;
    @Resource
    private MchInfoMapper mchInfoMapper;
    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private AgentService agentService;
    @Autowired
    private IVirtualAccountService virtualAccountService;
    @Resource
    private VirtualAccountMapper virtualAccountMapper;
    @Resource
    private VirtualAccountDetailMapper virtualAccountDetailMapper;

    @Override
    public String getMethod() {
        return OpenMethodEnum.AGENT_PROFIT_SYNC.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(),"所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("applyId"), ErrorCode.PARAM_ERROR.getErrorCode(),"applyId为空");
        AssertUtils.customHasLength(jsonObject.getString("profitType"), ErrorCode.PARAM_ERROR.getErrorCode(),"profitType为空");

        AssertUtils.customHasLength(jsonObject.getString("tradeChargeProfitAmount"), ErrorCode.PARAM_ERROR.getErrorCode(),"tradeChargeProfitAmount为空");
        AssertUtils.customHasLength(jsonObject.getString("tradeAddChargeProfitAmount"), ErrorCode.PARAM_ERROR.getErrorCode(),"tradeAddChargeProfitAmount为空");
        AssertUtils.customHasLength(jsonObject.getString("otherProfitAmount"), ErrorCode.PARAM_ERROR.getErrorCode(),"otherProfitAmount为空");
        AssertUtils.customHasLength(jsonObject.getString("totalProfitAmount"), ErrorCode.PARAM_ERROR.getErrorCode(),"totalProfitAmount为空");
        if(jsonObject.getLong("totalProfitAmount").longValue()!=(jsonObject.getLong("tradeChargeProfitAmount")+jsonObject.getLong("tradeAddChargeProfitAmount")
                +jsonObject.getLong("otherProfitAmount"))){
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),"totalProfitAmount错误");
        }
        OrderInfo orderInfo=null;
        if("1".equals(jsonObject.getString("profitType"))){
            AssertUtils.customHasLength(jsonObject.getString("tradeProfitRate"), ErrorCode.PARAM_ERROR.getErrorCode(),"tradeProfitRate为空");
            AssertUtils.customHasLength(jsonObject.getString("serial"), ErrorCode.PARAM_ERROR.getErrorCode(),"serial为空");
            //查询订单是否存在
            OrderInfoExample example=new OrderInfoExample();
            example.createCriteria().andSerialEqualTo(jsonObject.getString("serial"));
            List<OrderInfo> orderInfos=orderInfoMapper.selectByExample(example);
            AssertUtils.collectIsEmpty(orderInfos,ErrorCode.PARAM_ERROR.getErrorCode(),"serial关联的订单不存在");
            orderInfo=orderInfos.get(0);
        }
        if(StringUtils.isEmpty(jsonObject.getString("agentId"))&&StringUtils.isEmpty(jsonObject.getString("mchId"))){
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),"agentId和mchId不能同时为空");
        }
        ProfitDetailExample example=new ProfitDetailExample();
        example.createCriteria().andApplyIdEqualTo(jsonObject.getString("applyId"))
                .andOrgIdEqualTo(jsonObject.getLong("orgId"));
        int count=profitDetailMapper.countByExample(example);
        if(count>0){
            throw new BusinessException(ErrorCode.HAS_EXIT.getErrorCode(),"applyId已经存在");
        }
        String profitOrg="";
        String profitOrgType="";
        String profitOrgName="";
        String virtualNo="";
        AgentInfo agentInfo=null;
        if(!StringUtils.isEmpty(jsonObject.getString("agentId"))){
             agentInfo=agentInfoMapper.selectByPrimaryKey(jsonObject.getLong("agentId"));
            AssertUtils.customNotNull(agentInfo, ErrorCode.PARAM_ERROR.getErrorCode(),"agentId不存在");
            if(agentInfo.getOrgId().longValue()!=jsonObject.getLong("orgId")){
                throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),"agentId在该机构下不存在");
            }
            if(orderInfo!=null){
                //判断当前代理商是否属于交易商户的代理商
                List<AgentInfo> agentInfos=agentService.queryMchtAllUpperAgent(orderInfo.getAgentId());
                List<Long> agentIdList=agentInfos.stream().map(e->e.getId()).collect(Collectors.toList());
                if(!agentIdList.contains(agentInfo.getId())){
                    throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),"agentId与serial关联的订单不存在关联关系");
                }
            }
            profitOrg=agentInfo.getId()+"";
            profitOrgType="2";
            profitOrgName=agentInfo.getAgentName();
            if(StringUtils.isEmpty(agentInfo.getVirtualNo())){
                //创建虚户
                agentInfo.setVirtualNo(virtualAccountService.createAccount("1"));
                agentInfoMapper.updateByPrimaryKeySelective(agentInfo);
            }
            virtualNo=agentInfo.getVirtualNo();
        }
        MchInfo mchInfo=null;
        if(!StringUtils.isEmpty(jsonObject.getString("mchId"))){
            mchInfo= mchInfoMapper.selectByPrimaryKey(jsonObject.getLong("mchId"));
            //判断是不是商户自身，不是商户自身不处理
            if(orderInfo!=null&&orderInfo.getMchId().longValue()!=mchInfo.getId()){
                throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),"mchId和serial无关联关系");
            }
            profitOrg=mchInfo.getId()+"";
            profitOrgType="3";
            profitOrgName=mchInfo.getMchName();
            if(StringUtils.isEmpty(mchInfo.getVirtualNo())){
                //创建虚户
                mchInfo.setVirtualNo(virtualAccountService.createAccount("1"));
                mchInfoMapper.updateByPrimaryKeySelective(mchInfo);
            }
            virtualNo=mchInfo.getVirtualNo();
        }
        //保存分润流水
        ProfitDetail record=new ProfitDetail();
        record.setProfitOrg(profitOrg);
        record.setProfitOrgType(profitOrgType);
        record.setProfitOrgName(profitOrgName);
        record.setVirtualNo(virtualNo);
        record.setProfitType(jsonObject.getString("profitType"));
        record.setProfitRemark(jsonObject.getString("profitRemark"));
        record.setSerial(jsonObject.getString("serial"));
        record.setApplyId(jsonObject.getString("applyId"));
        record.setOrgId(jsonObject.getLong("orgId"));
        record.setPlatSerial(UUID.randomUUID().toString().replaceAll("-",""));
        if(orderInfo!=null) {
            record.setProduct(orderInfo.getProduct());
            record.setCardType(orderInfo.getCardType());
            record.setTradeAmount(orderInfo.getOrderAmount());
            record.setTradeChargeAmount(orderInfo.getChargeAmount());
            record.setTradeAddChargeAmount(orderInfo.getAddFeeAmount());
            record.setTradeRate(orderInfo.getChargeRate());
            record.setTradeFinishTime(orderInfo.getFinishTime());
            record.setTradeMchtId(orderInfo.getMchId());
            record.setTradeMchtName(orderInfo.getMchName());
        }

        record.setTradeChargeProfitAmount(jsonObject.getLong("tradeChargeProfitAmount"));
        record.setTradeAddChargeProfitAmount(jsonObject.getLong("tradeAddChargeProfitAmount"));
        record.setOtherProfitAmount(jsonObject.getLong("otherProfitAmount"));
        record.setTotalProfitAmount(jsonObject.getLong("totalProfitAmount"));
        record.setTradeProfitRate(jsonObject.getString("tradeProfitRate"));
        record.setSource("2");
        record.setProfitDate(DateUtil.getFormat(new Date(),"yyyy-MM-dd"));
        record.setCreateTime(new Date());
        record.setProfitAccountType("1");//进入余额账户
        profitDetailMapper.insertSelective(record);
        //这里如果是是进入待结算账户的话,需要处理,添加待结算记录，实时
        if("2".equals(record.getProfitAccountType())){
            VirtualAccount  virtualAccount=virtualAccountMapper.selectByLock(record.getVirtualNo());
            AssertUtils.customNotNull(virtualAccount,ErrorCode.PARAM_ERROR.getErrorCode(),"账户不存在");
            //修改账户待结算余额
            virtualAccount.setDisUseAmount((Long.parseLong(virtualAccount.getDisUseAmount())+record.getTotalProfitAmount())+"");
            virtualAccount.setUpdateTime(new Date());
            virtualAccountMapper.updateByPrimaryKeySelective(virtualAccount);
            //插入一笔入账流水
            VirtualAccountDetail virtualAccountDetailU=new VirtualAccountDetail();
            virtualAccountDetailU.setVirtualNo(virtualAccount.getVirtualNo());
            virtualAccountDetailU.setIsAdd("in");
            virtualAccountDetailU.setActType("2");
            virtualAccountDetailU.setAmount(record.getTotalProfitAmount()+"");
            virtualAccountDetailU.setCharge("0");
            virtualAccountDetailU.setFinalAmount(virtualAccount.getDisUseAmount());
            virtualAccountDetailU.setRemark("分润");
            virtualAccountDetailU.setActDate(DateUtil.getFormat(new Date(),"yyyy-MM-dd"));
            virtualAccountDetailU.setSerial(record.getPlatSerial());
            virtualAccountDetailU.setAddBlance("0");
            virtualAccountDetailU.setAddName("系统自动");
            virtualAccountDetailU.setCreateTime(new Date());
            virtualAccountDetailMapper.insertSelective(virtualAccountDetailU);
        }
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "申请成功");
        result.put("platSerial", record.getPlatSerial());
        return result;
    }
}
