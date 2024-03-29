package com.jkf.channel.gateway.constant;

/**
 * @author xiangyu
 * @date 2023/10/30 15:53
 */
public enum ErrorCode {
    SUCCESS("0000","成功"),
    FAIL("0001","失败"),
    EXCEPTION("0002","系统异常"),
    PARAM_ERROR("0003","参数错误"),
    SIGN_FAIL("0004","签名失败"),
    NO_PERMISSION("0005","无接口权限"),
    HAS_EXIT("0006","已存在"),
    PHONE_HAS_EXIT("0007","手机号已注册"),
    HAS_NOT_EXIT("0008","不存在"),
    HAS_OPEN_SUCCESS("0009","渠道已经开户成功"),
    PAYING("0010","处理中"),
    CHECK_ING("0011","审核中"),
    BLANCE_NOT_ENOUGH("0012","余额不足"),

    BING_CARD_FAIL("0097","绑卡失败"),
    OPEN_FAIL("0098","开户失败"),
    ;

    private String errorCode;
    private String errorMsg;

    ErrorCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
