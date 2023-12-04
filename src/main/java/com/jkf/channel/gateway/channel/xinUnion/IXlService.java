package com.jkf.channel.gateway.channel.xinUnion;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 15:22
 */
public interface IXlService {

    /**
     * 开户
     * @param param
     * @return
     */
    public Map<String, Object> register(JSONObject param);

    /**
     * 查询商户的状态
     * @param param
     * @return
     */
    public Map<String, Object> queryStatus(JSONObject param);

    /**
     *  注册审核通知:
     * @param bodyParam 通知参数
     * @param orderId 申请id
     * @return
     */
    public Map<String,Object> registerNotify(String bodyParam,String orderId);
}
