package com.jkf.channel.gateway.controller;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.BeanConstants;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.entity.ChannelInfo;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 对外的接口入口
 * @author xiangyu
 * @date 2023/10/30 14:52
 */
@Controller
@Slf4j
public class OpenController {

    @RequestMapping("openChannel/test")
    @ResponseBody
    public Object test(){
        Map<String,String> map=new HashMap<>();
        map.put("resultCode","0000");
        map.put("resultMsg","服务正常");
        return map;
    }
    /**
     * 请求处理器
     * @param params
     * @return
     */
    /**
     * 统一提供接口
     * @param params
     * @return
     */
    @RequestMapping(value = "openChannel/buss",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String handler(@RequestBody JSONObject params){
        String method=params.getString("method");
        //根据method查询到处理类
        IOpenHandler openHandler= BeanConstants.handlerMap.get(method);
        if(openHandler==null){
             return JSONObject.toJSONString(ResultUtils.businessResult(ErrorCode.FAIL.getErrorCode(),"method不支持"));
        }
        try {
            return JSONObject.toJSONString(openHandler.handler(params));
        }catch (BusinessException e){
            return JSONObject.toJSONString(ResultUtils.businessResult(e.getCode(),e.getMessage()));
        }catch (Exception e){
            log.error("系统异常",e);
            return JSONObject.toJSONString(ResultUtils.businessResult(ErrorCode.EXCEPTION.getErrorCode(),"系统异常"));
        }
    }
}
