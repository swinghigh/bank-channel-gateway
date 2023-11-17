package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.handler.IOpenHandler;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 分期商户绑卡
 * @author xiangyu
 * @date 2023/11/17 19:09
 */
@Service
public class FqMchtBindCardHandler  implements IOpenHandler {
    @Override
    public String getMethod() {
        return OpenMethodEnum.FQ_MCHT_BIND_CARD.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        return null;
    }
}
