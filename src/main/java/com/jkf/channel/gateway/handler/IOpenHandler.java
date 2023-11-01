package com.jkf.channel.gateway.handler;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/5/29 19:41
 */
public interface IOpenHandler {

    public String getMethod();

    /**
     * 执行业务
     * @param jsonObject
     * @return
     */
    public Map<String, Object> handler(JSONObject jsonObject);
}
