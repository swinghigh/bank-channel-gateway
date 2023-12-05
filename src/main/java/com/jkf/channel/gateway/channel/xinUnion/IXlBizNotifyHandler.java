package com.jkf.channel.gateway.channel.xinUnion;

/**
 * @author xiangyu
 * @date 2023/12/5 14:05
 */
public interface IXlBizNotifyHandler {
    /**
     * 处理的通知的业务类型
     * @return
     */
    public String getBizType();
    /**
     * 信联的通知处理
     * @param bodyParam 通知的参数
     * @param orderId 商户申请id
     */
    public void notifyHandler(String bodyParam,String orderId);
}
