package com.jkf.channel.gateway.controller;

import com.jkf.channel.gateway.channel.xinUnion.IXlService;
import com.jkf.channel.gateway.constant.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 16:01
 */
@RestController
@RequestMapping("xinlianNotify")
@Slf4j
public class XlNotifyController {
    @Autowired
    private IXlService xlService;
    /**
     * 信联的注册回调处理
     * @return
     */
    @RequestMapping("register/{orderId}")
    public String register(HttpServletRequest request,@PathVariable("orderId") String orderId){
        //从request中获取body数据
        try {
             String bodyParam = IOUtils.toString(request.getInputStream(), CharEncoding.UTF_8);
            log.info("得到的盛付通的通知参数为:{}", bodyParam);
            Map<String,Object> result=xlService.registerNotify(bodyParam,orderId);
            log.info("处理结果:{}",result);
            if(ErrorCode.SUCCESS.getErrorCode().equals(result.get("resultCode"))){
                return "SUCCESS";
            }else{
                return "FAIL";
            }
        }catch (Exception e){
            log.error("出现异常",e);
            return "FAIL";
        }
    }
}
