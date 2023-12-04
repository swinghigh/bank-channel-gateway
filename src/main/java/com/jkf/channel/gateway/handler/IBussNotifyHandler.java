package com.jkf.channel.gateway.handler;

import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 20:00
 */
public interface IBussNotifyHandler {
    /**
     * 通知处理类型
     * @return
     */
    public String getBusType();
    /**
     * 通知之前的处理
     * @param busMap
     */
    public void notifyPre(Map<String,Object> busMap);

    /**
     * 推送之后
     * @param busMap
     * @param result 推送对方响应的结果 exception为推送异常 SUCCESS为成功
     */
    public void notifyAfter(Map<String,Object> busMap,String result);
}
