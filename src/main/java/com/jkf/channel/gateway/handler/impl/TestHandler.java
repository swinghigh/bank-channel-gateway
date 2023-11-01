package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/10/31 15:02
 */
@Service
@Slf4j
public class TestHandler implements IOpenHandler {
    @Override
    public String getMethod() {
        return OpenMethodEnum.TEST.getMethod();
    }

    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        return ResultUtils.defaultBusinessResult("测试");
    }
}
