package com.jkf.channel.gateway.advice;

import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * controller的异常拦截类
 *
 * @author xiangyu
 * @date 2022/11/11 12:04
 */
@RestControllerAdvice
public class ExceptionControllerHandler {
    private static Logger logger = LoggerFactory.getLogger(ExceptionControllerHandler.class);

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(Exception.class)
    public String handleRenException(Exception e) {
        logger.error("controller异常", e);
        return ResultUtils.publicResult(ErrorCode.EXCEPTION.getErrorCode(), "系统异常");
    }
}
