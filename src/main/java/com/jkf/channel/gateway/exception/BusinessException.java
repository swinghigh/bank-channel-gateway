package com.jkf.channel.gateway.exception;

import com.jkf.channel.gateway.constant.ErrorCode;

/**
 * @author xiangyu
 * @date 2023/3/22 10:22
 */
public class BusinessException extends RuntimeException {

    private String code;

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }
    public BusinessException(ErrorCode error) {
        super(error.getErrorMsg());
        this.code = error.getErrorCode();
    }
    public BusinessException(Throwable cause, String code, String msg) {
        super(msg, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
