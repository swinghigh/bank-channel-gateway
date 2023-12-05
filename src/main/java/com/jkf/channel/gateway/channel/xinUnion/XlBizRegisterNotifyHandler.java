package com.jkf.channel.gateway.channel.xinUnion;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.XlBizTypeNotifyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理信联的进件通知
 * @author xiangyu
 * @date 2023/12/5 14:10
 */
@Service
@Slf4j
public class XlBizRegisterNotifyHandler implements IXlBizNotifyHandler {
    @Autowired
    private IXlService xlService;
    @Override
    public String getBizType() {
        return XlBizTypeNotifyEnum.PosMerAuditNotify.getBizType();
    }

    @Override
    public void notifyHandler(String bodyParam, String orderId) {
        log.info("收到信联的进件通知:{}-{}",orderId,bodyParam);
//        JSONObject respData = JSONObject.parseObject(bodyParam);
        xlService.registerNotify(bodyParam,orderId);
    }
}
