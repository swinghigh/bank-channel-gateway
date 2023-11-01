package com.jkf.channel.gateway.utils;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数处理类
 * @author xiangyu
 * @date 2023/10/30 16:02
 */
public class ResultUtils {

    public static String defaultFailResult(String msg){
        Map<String, Object> result=new HashMap<>(2);
        result.put(KeyConstants.CODE, ErrorCode.FAIL);
        result.put(KeyConstants.MSG,msg);
        return JSONObject.toJSONString(result);
    }
    public static String publicResult(String code,String msg){
        Map<String, Object> result=new HashMap<>(2);
        result.put(KeyConstants.CODE, code);
        result.put(KeyConstants.MSG,msg);
        return JSONObject.toJSONString(result);
    }

    public static Map<String, Object> defaultBusinessResult(String msg){
        Map<String, Object> result=new HashMap<>(2);
        result.put(KeyConstants.RESULT_CODE, ErrorCode.FAIL);
        result.put(KeyConstants.RESULT_MSG,msg);
        return result;
    }
    public static Map<String, Object> businessResult(String resultCode,String resultMsg){
        Map<String, Object> result=new HashMap<>(2);
        result.put(KeyConstants.RESULT_CODE, resultCode);
        result.put(KeyConstants.RESULT_MSG,resultMsg);
        return result;
    }
}
