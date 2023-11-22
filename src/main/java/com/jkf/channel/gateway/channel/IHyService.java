package com.jkf.channel.gateway.channel;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/21 13:48
 */
public interface IHyService {
    /**
     * 开户
     * @param param
     * @return
     */
    public Map<String, Object> register(JSONObject param);

    /**
     * 修改基础信息
     * @param param
     * @return
     */
    public Map<String, Object> edit(JSONObject param);

    /**
     * 单独绑卡接口
     * @param param
     * @return
     */
    public Map<String,Object> bindCard(JSONObject param);

    /**
     * 添加地址
     * @param param
     * @return
     */
    public Map<String,Object> addRess(JSONObject param);

    /**
     * 人脸授权token
     * @param param
     * @return
     */
    public Map<String,Object> authToken(JSONObject param);

    /**
     * 人脸授权token查询
     * @param param
     * @return
     */
    public Map<String,Object> authTokenQuery(JSONObject param);
}
