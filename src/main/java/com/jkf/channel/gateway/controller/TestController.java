package com.jkf.channel.gateway.controller;

import com.jkf.channel.gateway.dao.ChannelInfoMapper;
import com.jkf.channel.gateway.entity.ChannelInfo;
import com.jkf.channel.gateway.handler.ReconcileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiangyu
 * @date 2023/10/27 19:02
 */
@Slf4j
@Controller
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

    /**
     *
     * @return
     */
    @PostMapping("test/notifySuccess")
    @ResponseBody
    public String notifySuccess(@RequestBody Object params){
        log.info("params:{}",params);

        return "success";
    }


    @GetMapping("test/apply")
    @ResponseBody
    public Object download(String date){
        String key= "xinLianReconcileTask:"  + date;
        try {
//            boolean reconcile = RedisUtil.setNx(key, "1", 10, TimeUnit.MINUTES);
            boolean reconcile=true;
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


    @GetMapping("test/reconcile")
    @ResponseBody
    public Object reconcile(String date){
        String key= "xinLianReconcileTask:"  + date;
        try {
//            boolean reconcile = RedisUtil.setNx(key, "1", 10, TimeUnit.MINUTES);
            boolean reconcile=true;
            if (reconcile){
                reconcileService.xinLianReconcile(date);
            }else {
                return "fail";
            }
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

}
