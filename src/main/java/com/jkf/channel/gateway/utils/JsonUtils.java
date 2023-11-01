package com.jkf.channel.gateway.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

/**
 * The class JsonUtils.
 * <p>
 * Description:
 *
 * @author: wuweikun
 * @since: 2020/04/17
 */

public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final ObjectMapper NOT_EMPTY_MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
        MAPPER.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        NOT_EMPTY_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        NOT_EMPTY_MAPPER.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        NOT_EMPTY_MAPPER.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
        NOT_EMPTY_MAPPER.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
    }

    public static String toJson(Object obj) {

        return toJson(obj, false);
    }

    public static String toJson(Object obj, boolean isIngoreEmpty) {
        StringWriter sw = new StringWriter();

        try {
            JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
            if (isIngoreEmpty) {
                NOT_EMPTY_MAPPER.writeValue(gen, obj);
            } else {
                MAPPER.writeValue(gen, obj);
            }
            gen.close();
        } catch (JsonGenerationException e) {
            logger.error("", e);

        } catch (JsonMappingException e) {
            logger.error("", e);

        } catch (IOException e) {
            logger.error("", e);

        }

        return sw.toString();
    }

    /**
     * 将JSON字符串 转换为对象
     *
     * @author weiyuanhua
     * @date 2010-11-18 下午02:52:13
     * @param jsonStr
     *            JSON字符串
     * @param beanClass
     *            泛型对象
     * @return
     */
    public static <T> T jsonToObject(String jsonStr, Class<T> beanClass) throws JsonParseException, JsonMappingException, IOException {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        return MAPPER.readValue(jsonStr, beanClass);
    }

    public static <T> T jsonToObject(String jsonStr, String encoding, Class<T> beanClass) throws JsonParseException, JsonMappingException, IOException {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        return MAPPER.readValue(jsonStr.getBytes(encoding), beanClass);
    }

    public static Object jsonToCollection(String jsonStr, Class<?> collectionClass, Class<?>... elementClasses) throws JsonParseException, JsonMappingException, IOException {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        JavaType javaType = getParametrizedType(collectionClass, elementClasses);
        return MAPPER.readValue(jsonStr, javaType);
    }

    public static Object jsonToCollection(String jsonStr, String encoding, Class<?> collectionClass, Class<?>... elementClasses) throws JsonParseException, JsonMappingException, IOException {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        JavaType javaType = getParametrizedType(collectionClass, elementClasses);
        return MAPPER.readValue(jsonStr.getBytes(encoding), javaType);
    }

    /**
     * 获取集合的JavaType
     * 
     * @param parametrized
     * @param parameterClasses
     * @return
     */
    public static JavaType getParametrizedType(Class<?> parametrized, Class<?>... parameterClasses) {
        return MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    public static <T> T jsonToObject(String jsonStr, TypeReference<T> type) throws JsonParseException, JsonMappingException, IOException {

        return MAPPER.readValue(jsonStr.getBytes("UTF-8"), type);
    }

    public static <T> T jsonToObject(String jsonStr, JavaType type, Class<T> t) throws JsonParseException, JsonMappingException, IOException {
        return MAPPER.readValue(jsonStr.getBytes("UTF-8"), type);
    }

    public static <T> T jsonToObject(String jsonStr, Class<T> respClass, Class<?>... parameterClasses) throws JsonParseException, JsonMappingException, IOException {
        JavaType parametrizedType = JsonUtils.getParametrizedType(respClass, parameterClasses);
        return MAPPER.readValue(jsonStr.getBytes("UTF-8"), parametrizedType);
    }

    public static <T> T jsonToObject(String jsonStr, String encoding, TypeReference<T> type) throws JsonParseException, JsonMappingException, IOException {
        return MAPPER.readValue(jsonStr.getBytes(encoding), type);
    }

    public static Map<String, Object> parseJson2Map(String jsonStr) throws JsonParseException, JsonMappingException, IOException {
        if (StringUtils.isBlank(jsonStr)) {
            return Collections.emptyMap();
        }
        return MAPPER.readValue(jsonStr, Map.class);
    }

    /**
     * 把对象转换成json数据
     *
     * @param bean
     * @param ignoreVar
     * @return
     */
    public static String toJson(Object bean, String... ignoreVar) {

        BeanInfo beanInfo = null;
        StringBuilder sBuilder = null;
        try {
            sBuilder = new StringBuilder();
            beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor propertyDescriptors[] = beanInfo.getPropertyDescriptors();
            sBuilder.append("{");
            for (PropertyDescriptor property : propertyDescriptors) {
                String propertyName = property.getName();
                if (!"class".equals(propertyName) && !isContains(propertyName, ignoreVar)) {
                    Method readMethod = property.getReadMethod();
                    String result = (String) readMethod.invoke(bean, new Object[0]);
                    if (result == null) {
                        result = "";
                    }
                    sBuilder.append("\"" + propertyName + "\":\"" + result + "\",");
                    logger.debug("\"" + propertyName + "\":\"" + result + "\"");
                }
            }
            String temp = sBuilder.toString();
            if (temp.length() > 0) {
                String result = temp.substring(0, temp.lastIndexOf(","));
                return result + "}";
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.debug("exception" + e.getMessage());
            return null;
        }
    }

    /**
     * 判断被忽略的字段是否等于当前字段
     *
     * @param propertyName
     * @param ignoreVar
     * @return
     */
    private static boolean isContains(String propertyName, String[] ignoreVar) {
        if (ignoreVar != null && ignoreVar.length > 0) {
            for (String str : ignoreVar) {
                if (propertyName.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
