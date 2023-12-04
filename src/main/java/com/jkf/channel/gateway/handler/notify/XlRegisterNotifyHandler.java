package com.jkf.channel.gateway.handler.notify;

import com.jkf.channel.gateway.constant.BusNotifyEnum;
import com.jkf.channel.gateway.handler.IBussNotifyHandler;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 20:28
 */
@Service
public class XlRegisterNotifyHandler  implements IBussNotifyHandler {
    @Override
    public String getBusType() {
        return BusNotifyEnum.XL_REGISTER.getBussType();
    }

    @Override
    public void notifyPre(Map<String, Object> busMap) {

    }

    @Override
    public void notifyAfter(Map<String, Object> busMap, String result) {

    }
}
