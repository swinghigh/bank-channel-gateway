package com.jkf.channel.gateway.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 20:06
 */
@Data
public class NotifyVo implements Serializable {
    private static final long serialVersionUID = -123293822009002L;
    /**
     * 推送地址
     */
    private String notifyUrl;
    /**
     * 当前次数
     */
    private String currentCount;
    /**
     * 最大推送次数
     */
    private String maxCount;
    /**
     * 推送内容
     */
    private String content;
    /**
     * 推送的业务类型
     */
    private String busHandlerType;
    /**
     * 业务数据
     */
    private Map<String, Object> bussMap;
}
