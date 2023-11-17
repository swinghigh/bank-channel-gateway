package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.handler.IOpenHandler;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 分期商户修改
 * @author xiangyu
 * @date 2023/11/17 19:08
 */
@Service
public class FqMchtEditHandler  implements IOpenHandler {
    @Override
    public String getMethod() {
        return OpenMethodEnum.FQ_MCHT_EDIT.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        return null;
    }
}
