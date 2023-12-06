package com.jkf.channel.gateway.controller;

import com.jkf.channel.gateway.dao.ChannelInfoMapper;
import com.jkf.channel.gateway.entity.ChannelInfo;
import com.jkf.channel.gateway.handler.ReconcileService;
import com.jkf.channel.gateway.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author xiangyu
 * @date 2023/10/27 19:02
 */
@RestController
public class TestController {
    @Resource
    private ChannelInfoMapper channelInfoMapper;
    @Resource
    private ReconcileService reconcileService;

    @RequestMapping("test/find")
    public Object find(){
        ChannelInfo info= channelInfoMapper.selectByPrimaryKey(1L);
        return info;
    }

    @RequestMapping("test/apply")
    public Object download(String date){
        String key= "xinLianReconcileTask:"  + date;
        try {
            boolean reconcile = RedisUtil.setNx(key, "1", 10, TimeUnit.MINUTES);
            if (reconcile){
                reconcileService.downloadXinLianFile(date);
            }else {
                return "fail";
            }
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

}
