package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.handler.IOpenHandler;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/17 19:10
 */
@Service
public class FqMchtQueryHandler implements IOpenHandler {
    @Override
    public String getMethod() {
        return OpenMethodEnum.FQ_MCHT_QUERY.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        return null;
    }
}
