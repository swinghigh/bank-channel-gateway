package com.jkf.channel.gateway.service.impl;

import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;
import com.jkf.channel.gateway.constant.RedisConstants;
import com.jkf.channel.gateway.dao.OrgInfoMapper;
import com.jkf.channel.gateway.dao.OrgInterfceKeyMapper;
import com.jkf.channel.gateway.entity.OrgInfo;
import com.jkf.channel.gateway.entity.OrgInterfceKey;
import com.jkf.channel.gateway.entity.OrgInterfceKeyExample;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IBussNotifyHandler;
import com.jkf.channel.gateway.service.IBussinessNotifyService;
import com.jkf.channel.gateway.utils.*;
import com.jkf.channel.gateway.vo.NotifyVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 19:42
 */
@Service
@Slf4j
public class BussinessNotifyServiceImpl implements IBussinessNotifyService {
    @Resource
    private OrgInterfceKeyMapper orgInterfceKeyMapper;
    @Resource
    private OrgInfoMapper orgInfoMapper;
    @Autowired
    private List<IBussNotifyHandler> bussNotifyHandlers;

    private IBussNotifyHandler getHandler(String busNotifyType){
        if(StringUtils.isEmpty(busNotifyType)){

            return null;
        }
        if(bussNotifyHandlers!=null){
            for(IBussNotifyHandler bussNotifyHandler:bussNotifyHandlers){
                if(busNotifyType.equals(bussNotifyHandler.getBusType())){
                    return bussNotifyHandler;
                }
            }
        }
        return null;
    }

    @Override
    public void busNotify(Map<String, Object> bussMap, Long orgId, String notifyUrl,String currentCount,String maxCount,String busHandlerType) {
//        OrgInfo orgInfo=orgInfoMapper.selectByPrimaryKey(orgId);
        OrgInterfceKeyExample example=new OrgInterfceKeyExample();
        example.createCriteria().andOrgIdEqualTo(orgId);
        List<OrgInterfceKey> orgInterfceKeys=orgInterfceKeyMapper.selectByExample(example);
        OrgInfo orgInfo=orgInfoMapper.selectByPrimaryKey(orgId);
        OrgInterfceKey orgInterfceKey=orgInterfceKeys.get(0);
        for(OrgInterfceKey orgInterfceKeyTemp:orgInterfceKeys){
            if(orgInterfceKey.getOrgAppNo().equals(orgInfo.getOrgNo())){
                orgInterfceKey=orgInterfceKeyTemp;
                break;
            }
        }
        busNotify(bussMap, orgInterfceKey,  notifyUrl,currentCount,maxCount,busHandlerType);
    }

    @Override
    public void busNotify(Map<String, Object> bussMap, String orgAppNo, String notifyUrl,String currentCount,String maxCount,String busHandlerType) {
        OrgInterfceKeyExample example=new OrgInterfceKeyExample();
        example.createCriteria().andOrgAppNoEqualTo(orgAppNo);
        List<OrgInterfceKey> orgInterfceKeys=orgInterfceKeyMapper.selectByExample(example);
        OrgInterfceKey orgInterfceKey=orgInterfceKeys.get(0);
        busNotify(bussMap, orgInterfceKey,  notifyUrl,currentCount,maxCount,busHandlerType);
    }

    private void busNotify(Map<String, Object> bussMap,OrgInterfceKey orgInterfceKey, String notifyUrl,String currentCount,String maxCount,String busHandlerType){
        Map<String, Object> result = new HashMap<>();
        result.put(KeyConstants.CODE, ErrorCode.SUCCESS.getErrorCode());
        result.put(KeyConstants.MSG, "操作成功");
        //使用机构的公钥加密
        try {
            log.info("请求的报文的明文:{}",bussMap);
            result.put("respData", RSAUtil.publicEncrypt(JsonUtils.toJson(bussMap), orgInterfceKey.getOrgPublicKey()));
            //7.加签,平台的私钥生成签名
            result.put("sign", RSAUtil.sign(result, orgInterfceKey.getPlatPrivateKey()));
        }catch (Exception e){
            throw new BusinessException(ErrorCode.FAIL.getErrorCode(),"签名失败");
        }
        NotifyVo notifyVo=new NotifyVo();
        notifyVo.setBusHandlerType(busHandlerType);
        notifyVo.setBussMap(bussMap);
        notifyVo.setContent(JsonUtils.toJson(result));
        notifyVo.setCurrentCount(currentCount);
        notifyVo.setMaxCount(maxCount);
        notifyVo.setNotifyUrl(notifyUrl);
        busNotify( notifyVo);
    }

    @Override
    public void busNotify(NotifyVo notifyVo) {
        IBussNotifyHandler bussNotifyHandler=getHandler( notifyVo.getBusHandlerType());
        if(bussNotifyHandler!=null){
            try {
                bussNotifyHandler.notifyPre(notifyVo.getBussMap());
            }catch (Exception e){
                log.error("出现异常",e);
            }
        }
        //发送http
        log.info("请求的地址:{}",notifyVo.getNotifyUrl());
        log.info("请求的报文:{}",notifyVo.getContent());
        String resp=null;
        try {
            resp = HttpUtil.sendJson(notifyVo.getNotifyUrl(), notifyVo.getContent());
        }catch (Exception e){
            log.error("出现异常",e);
            resp="EXCEPTION";
        }
        log.info("请求的响应报文:{}",resp);
        if(bussNotifyHandler!=null){
            try {
                bussNotifyHandler.notifyAfter(notifyVo.getBussMap(),resp);
            }catch (Exception e){
                log.error("出现异常",e);
            }
        }
        if("SUCCESS".equals(resp)){
            //发送成功
            //暂时不处理
        }else{
            if(Integer.parseInt(notifyVo.getCurrentCount())<Integer.parseInt(notifyVo.getMaxCount())){
                notifyVo.setCurrentCount(Integer.parseInt(notifyVo.getCurrentCount())+1+"");
                log.info("加入redis重新处理{}",notifyVo.getNotifyUrl());
                //将信息加入redis,
                long time=getNextTime(notifyVo.getCurrentCount());
                log.info("下一次的次数:{}下次的执行时间:{}",notifyVo.getCurrentCount(),time);
                RedisUtil.zset(RedisConstants.REDIS_NOTIFY_SET,time,JsonUtils.toJson(notifyVo));
            }else{
                log.info("达到处理的上线");
            }
        }
    }

    /**
     * 下一次执行的时间
     * @param nextCount
     * @return
     */
    private Long getNextTime(String nextCount){
        if(Integer.parseInt(nextCount)<=3){
            //当前时间加30秒
//            return DateUtil.getDateByCutDayAfterSecond(30).getTime();
            return System.currentTimeMillis()+10*1000;
        }else if(Integer.parseInt(nextCount)<=5){
            //当前时间加2分钟
//           return DateUtil.getDateByCutDayAfterMinute(2).getTime();
            return System.currentTimeMillis()+60*1000*2;
        }else{
            //当前时间加10分钟
//            return DateUtil.getDateByCutDayAfterMinute(10).getTime();
            return System.currentTimeMillis()+60*1000*10;
        }
    }
}
