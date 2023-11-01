package com.jkf.channel.gateway.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * The class ObjectUtils.
 * <p>
 * Description:
 *
 * @author: wuweikun
 * @since: 2020/04/18
 */

public class ObjectUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ObjectUtils.class);

    /**
     * 判断对象是否是基本数据类型
     * 
     * @return
     */
    public static boolean isBasicDataType(Class<?> clazz) {
        boolean result = false;
        if (clazz.isPrimitive()) {
            result = true;
        } else if (String.class.isAssignableFrom(clazz)) {
            result = false;
        } else {
            try {
                Field[] fields = clazz.getDeclaredFields();
                if (null != fields) {
                    for (Field field : fields) {
                        if (field.isAccessible() && "TYPE".equals(field.getName())) {
                            Object value = field.get(null);
                            if (null != value && value instanceof Class && ((Class<?>) value).isPrimitive()) {
                                result = true;
                                break;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LOG.error("类 {} 不是基本数据类型", clazz.getName(), e);
            }
        }
        return result;
    }
}
