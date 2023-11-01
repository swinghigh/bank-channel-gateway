package com.jkf.channel.gateway.utils;

import com.jkf.channel.gateway.exception.BusinessException;
import org.springframework.util.StringUtils;
import reactor.util.annotation.Nullable;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author xiangyu
 * @date 2023/5/29 11:05
 */
public class AssertUtils {

    private static final Pattern EMOJI_PATTERN = Pattern.compile("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]");

    public static void customHasLength(@Nullable String text, String code, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new BusinessException(code,message);
        }
    }

    public static void customIsNull(@Nullable Object object, String code, String message) {
        if (null != object) {
            throw new BusinessException(code,message);
        }
    }

    public static void customIsTrue(boolean expression, String code, String message) {
        if (!expression) {
            throw new BusinessException(code,message);
        }
    }
    public static void customIsNotTrue(boolean expression, String code, String message) {
        if (expression) {
            throw new BusinessException(code,message);
        }
    }
    public static void customNotNull(@Nullable Object object, String code, String message) {
        if (null == object) {
            throw new BusinessException(code,message);
        }
    }

    public static void customIsInteger(@Nullable String text, String code, String message) {
        try {
            Integer.parseInt(text);
        } catch (Exception e) {
            throw new BusinessException(code,message);
        }
    }

    public static void customIsLong(@Nullable String text, String code, String message) {
        try {
            Long.parseLong(text);
        } catch (Exception e) {
            throw new BusinessException(code,message);
        }
    }

    public static void notEmoji(@Nullable String text, String code, String message) {
        if (StringUtils.hasLength(text) && EMOJI_PATTERN.matcher(text).find()) {
            throw new BusinessException(code,message);
        }
    }

    public static void notNum(@Nullable String text, String code, String message) {
        try {
            Long.parseLong(text);
        } catch (Exception e) {
            throw new BusinessException(code,message);
        }
    }

    /**
     * 当字符串的长度超过len时,抛出异常
     * @param text 字符串
     * @param len 长度
     * @param code 错误码
     * @param message 错误提示
     */
    public static void customTooLength(@Nullable String text, int len, String code, String message){
        if(!StringUtils.isEmpty(text)&&text.length()>len){
            throw new BusinessException(code,message);
        }
    }

    public static void collectIsEmpty(@Nullable List list, String code, String message) {
        if(list==null||list.size()==0){
            throw new BusinessException(code,message);
        }
    }
}
