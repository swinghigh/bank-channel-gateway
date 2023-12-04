package com.jkf.channel.gateway.channel.xinUnion;

/**
 * @author xiangyu
 * @date 2023/12/1 10:39
 */
public class XinUnionBaseParam {
/************* 请求固定参数 ******************/

    /**
     * 请求发送时的时间戳
     */
    long timestamp;
    /**
     * 随机数建议使用uuid
     */
    String random;

    /**
     * 敏感数据加密key id。加密算法为 SM2 时，表示 secretKey
     */
    String keyId;

    String signType="SM2";

    /**
     * 签名值
     */
    private String signature;
    /**
     * 接口版本
     */
    private String versionNo;

    /**
     * 商户编号/代理商编号
     */
    private String partnerId;
    /**
     * 业务类型
     */
    private String bizType;
}
