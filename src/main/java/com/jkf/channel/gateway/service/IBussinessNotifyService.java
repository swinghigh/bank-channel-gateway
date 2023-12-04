package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.vo.NotifyVo;

import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 19:38
 */
public interface IBussinessNotifyService {
    /**
     * 给机构推送数据
     * @param bussMap
     * @param orgId
     * @param notifyUrl
     */
    public void busNotify(Map<String, Object> bussMap, Long orgId, String notifyUrl,String currentCount,String maxCount,String busHandlerType);

    /**
     * 给应用的机构推送
     * @param bussMap
     * @param orgAppNo
     * @param notifyUrl
     */
    public void busNotify(Map<String, Object> bussMap, String orgAppNo, String notifyUrl,String currentCount,String maxCount,String busHandlerType);

    /**
     * 推送,主要是定时任务直接调用的
     * @param notifyVo
     */
    public void busNotify(NotifyVo notifyVo);
}
