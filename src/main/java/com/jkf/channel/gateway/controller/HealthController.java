package com.jkf.channel.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/2/14 9:26
 */
@RestController
public class HealthController {
    private static Logger logger= LoggerFactory.getLogger(HealthController.class);

    /**
     * 健康检测
     * @param request
     * @return
     */
    @RequestMapping("health")
    public Map<String,String> health(Map<String, String> request){
        Map<String,String> map=new HashMap<>();
        map.put("resultCode","0000");
        map.put("resultMsg","服务正常");
        return map;
    }
}
