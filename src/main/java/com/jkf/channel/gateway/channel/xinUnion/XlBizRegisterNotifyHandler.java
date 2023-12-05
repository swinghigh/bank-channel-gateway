package com.jkf.channel.gateway.channel.xinUnion;

import com.jkf.channel.gateway.constant.XlBizTypeNotifyEnum;
import org.springframework.stereotype.Service;

/**
 * @author xiangyu
 * @date 2023/12/5 14:10
 */
@Service
public class XlBizRegisterNotifyHandler implements IXlBizNotifyHandler {
    @Override
    public String getBizType() {
        return XlBizTypeNotifyEnum.PosMerAuditNotify.getBizType();
    }

    @Override
    public void notifyHandler(String bodyParam, String orderId) {

    }
}
