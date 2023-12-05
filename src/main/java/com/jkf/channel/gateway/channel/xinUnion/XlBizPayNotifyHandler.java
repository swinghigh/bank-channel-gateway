package com.jkf.channel.gateway.channel.xinUnion;

import com.jkf.channel.gateway.constant.XlBizTypeNotifyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xiangyu
 * @date 2023/12/5 14:12
 */
@Service
@Slf4j
public class XlBizPayNotifyHandler implements IXlBizNotifyHandler{
    @Override
    public String getBizType() {
        return XlBizTypeNotifyEnum.PayNotify.getBizType();
    }

    @Override
    public void notifyHandler(String bodyParam, String orderId) {
        log.info("收到支付通知:{}",bodyParam);
    }
}
