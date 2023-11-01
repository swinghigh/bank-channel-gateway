package com.jkf.channel.gateway.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * The class ClientUtils.
 * <p>
 * Description:
 *
 * @author: wuweikun
 * @since: 2020/04/18
 */

public class ClientUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ClientUtils.class);

    // 请求对象
    private static final String REQUEST_OBJECT = ClientUtils.class.getName() + ".request_object";

    // multipart请求解析
    private static MultipartResolver multipartResolver = new StandardServletMultipartResolver();

    public static MultipartResolver getMultipartResolver() {
        return multipartResolver;
    }

    public void setMultipartResolver(MultipartResolver multipartResolver) {
        ClientUtils.multipartResolver = multipartResolver;
    }

    /**
     * 获取参数值
     * 
     * @param request
     * @param name
     *            参数名称
     *
     * @return
     */
    public static String getParameter(HttpServletRequest request, String name) {
        String value = "";

        Map<String, String> requestMap = ClientUtils.getRequest2Map(request);
        if (null != requestMap && !requestMap.isEmpty()) {
            value = requestMap.get(name);
        }
        return value;
    }

    /**
     * 默认UTF-8方式，将请求字符串转换为对象
     *
     * @param request
     * @return
     */
    public static <T> T getRequest2Object(HttpServletRequest request, Class<? extends T> clazz) {
        String charset = request.getCharacterEncoding();
        if (StringUtils.isBlank(charset)) {
            charset = "UTF-8";
        }
        return getRequest2Object(request, clazz, charset);
    }

    /**
     * 将请求字符串转换为对象
     *
     * @param request
     * @param encoding
     *            编码方式
     *
     * @return
     */
    public static <T> T getRequest2Object(HttpServletRequest request, Class<T> clazz, String encoding) {

        // 请求对象
        T object = null;

        // request中的请求对象
        Object cache = request.getAttribute(REQUEST_OBJECT);
        if (null != cache) {
            if (clazz.isAssignableFrom(cache.getClass())) {
                return (T) cache;
            } else {
                object = BeanUtils.newInstance(clazz);
                BeanUtils.copyProperties(cache, object);
                return object;
            }
        }

        // 默认UTF-8
        if (StringUtils.isBlank(encoding)) {
            encoding = "UTF-8";
        }

        // 非multipart请求
        if (!isMultipart(request)) {
            String contentType = request.getContentType();

            // 非表单传递
            if (StringUtils.isNotBlank(contentType) && !contentType.contains(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) {
                object = getRequestStramObject(request, encoding, clazz);
            }
        }

        // 表单plain方式请求
        Enumeration<String> names = request.getParameterNames();
        if (names.hasMoreElements()) {
            if (null == object) {
                object = BeanUtils.newInstance(clazz);
            }
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                String value = request.getParameter(name);
                if (!"ISO-8859-1".equalsIgnoreCase(encoding) && isEncoding(value, "ISO-8859-1")) {
                    try {
                        value = new String(value.getBytes("ISO-8859-1"), encoding);
                    } catch (UnsupportedEncodingException e) {
                        LOG.error("值：" + value + "不支持编码" + encoding);
                    }
                }
                BeanUtils.copyProperty(object, name, value);
            }
        }

        // 放入request中
        request.setAttribute(REQUEST_OBJECT, object);
        return object;
    }

    /**
     * 封装multipart
     * 
     * @param request
     * @return
     */
    public static HttpServletRequest resolveMultipart(HttpServletRequest request) {

        // 本身是或者包含MultipartHttpServletRequest
        if (WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class) != null) {
            return request;
        }

        // 不存在封装的请求，则直接使用工具类生产封装请求对象
        if (isMultipart(request)) {
            if (null != multipartResolver) {
                return multipartResolver.resolveMultipart(request);
            }
        }
        return null;
    }

    /**
     * 是否是multipart
     * 
     * @param request
     * @return
     */
    public static boolean isMultipart(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (StringUtils.isNotBlank(contentType) && contentType.contains(MediaType.MULTIPART_FORM_DATA_VALUE)) {
            return true;
        }
        return null != multipartResolver && multipartResolver.isMultipart(request);
    }

    /**
     * 是否使用commons-upload
     * 
     * @return
     */
    public static boolean isCommonsUpload() {
        if (null != multipartResolver && multipartResolver instanceof CommonsMultipartResolver) {
            return true;
        }
        return false;
    }

    /**
     * 是否是form
     * 
     * @param request
     * @return
     */
    public static boolean isForm(ServletRequest request) {
        String contentType = request.getContentType();

        // 表单传递
        if (StringUtils.isBlank(contentType) || contentType.contains(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) {
            return true;
        }
        return false;
    }

    /**
     * 默认UTF-8方式，将请求字符串转换为Map
     *
     * @param request
     * @return
     */
    public static Map<String, String> getRequest2Map(HttpServletRequest request) {
        String charset = request.getCharacterEncoding();
        if (StringUtils.isBlank(charset)) {
            charset = "UTF-8";
        }
        return getRequest2Map(request, charset);
    }

    /**
     * 将请求字符串转换为Map
     *
     * @param request
     * @param encoding
     *            编码方式
     *
     * @return
     */
    public static Map<String, String> getRequest2Map(HttpServletRequest request, String encoding) {
        Map<String, String> resultMap = Collections.emptyMap();
        Map mapObj = getRequest2Object(request, HashMap.class, encoding);
        if (null != mapObj && !mapObj.isEmpty()) {
            resultMap = new HashMap<String, String>(mapObj.size());
            for (Object key : mapObj.keySet()) {
                String keyString = "";
                if (null != key) {
                    if (key instanceof String) {
                        keyString = (String) key;
                    } else {
                        keyString = key.toString();
                    }
                }

                String valueString = "";
                Object value = mapObj.get(key);
                if (null != value) {
                    if (value instanceof String) {
                        valueString = (String) value;
                    } else {
                        valueString = value.toString();
                    }
                }
                resultMap.put(keyString, valueString);
            }
        }
        return resultMap;
    }

    /**
     * 获取请求对象
     * 
     * @param request
     *
     * @param clazz
     *            请求类
     *
     * @return
     */
    public static <T> T getRequestStramObject(HttpServletRequest request, Class<T> clazz) {
        String charset = request.getCharacterEncoding();
        if (StringUtils.isBlank(charset)) {
            charset = "UTF-8";
        }
        return getRequestStramObject(request, charset, clazz);
    }

    /**
     * 获取请求对象
     * 
     * @param request
     * @param encoding
     *            编码
     *
     * @param clazz
     *            请求类
     *
     * @return
     */
    public static <T> T getRequestStramObject(HttpServletRequest request, String encoding, Class<T> clazz) {
        T object = null;

        String streamString = RequestUtils.getRequestStream(request, encoding);
        if (StringUtils.isNotBlank(streamString)) {

            // 键值对请求
            if (streamString.trim().matches("^([\\w$]+=[\\S\\s]*&)*[\\w$]+=[\\S\\s]*&?$")) {
                object = BeanUtils.newInstance(clazz);
                String[] entries = streamString.split("&");
                for (String entry : entries) {
                    if (entry.indexOf("=") > 0) {
                        String[] kv = entry.split("=");
                        String name = kv[0];
                        String value = kv[1];
                        if (!"ISO-8859-1".equalsIgnoreCase(encoding) && isEncoding(value, "ISO-8859-1")) {
                            try {
                                value = new String(value.getBytes("ISO-8859-1"), encoding);
                            } catch (UnsupportedEncodingException e) {
                                LOG.error("值：" + value + "不支持编码" + encoding);
                            }
                        }
                        BeanUtils.copyProperty(object, name, value);
                    }
                }
            } else {

                // json
                try {
                    object = JsonUtils.jsonToObject(streamString, encoding, clazz);
                } catch (JsonParseException e) {
                    LOG.error("解析json字符串失败！json=" + streamString);
                } catch (JsonMappingException e) {
                    LOG.error("json字符串映射对象失败！json=" + streamString);
                } catch (IOException e) {
                    LOG.error("json字符串读写失败！json=" + streamString);
                }
            }
        }
        return object;
    }

    /**
     * 获取对应类属性的请求Map
     * 
     * @param request
     * @param clazz
     *            请求类
     *
     * @return
     */
    public static <T> Map<String, String> getRequestForClass(HttpServletRequest request, Class<T> clazz) {
        String charset = request.getCharacterEncoding();
        if (StringUtils.isBlank(charset)) {
            charset = "UTF-8";
        }
        return getRequestForClass(request, clazz, charset);
    }

    /**
     * 获取对应类属性的请求Map
     * 
     * @param request
     * @param clazz
     *            请求类
     *
     * @param encoding
     *            编码
     *
     * @return
     */
    public static <T> Map<String, String> getRequestForClass(HttpServletRequest request, Class<T> clazz, String encoding) {
        Map<String, String> resultMap = new HashMap<String, String>();

        Map<String, String> origMap = getRequest2Map(request, encoding);
        if (null != origMap && !origMap.isEmpty()) {
            String[] names = BeanUtils.getPropertyNames(clazz);
            if (null == names || names.length == 0) {
                return Collections.emptyMap();
            }
            for (String name : names) {
                resultMap.put(name, origMap.get(name));
            }
        }
        return resultMap;
    }

    public static boolean isEncoding(String s, String charset) {
        try {
            if (s.equals(new String(s.getBytes(charset), charset))) {
                return true;
            }
        } catch (Exception e) {}
        return false;
    }

    /**
     * 判断指定IP是否在IP规则中
     * 
     * @param ip
     *            判断IP
     *
     * @param pattern
     *            IP规则，例如：192.168.1.64/26，192.168.1.64-192.168.1.127
     *
     */
    public static boolean isInRange(String ip, String pattern) {
        if (StringUtils.isBlank(ip) || StringUtils.isBlank(pattern)) {
            return false;
        }
        ip = ip.trim();
        pattern = pattern.trim();
        if (ip.equals(pattern)) {
            return true;
        }

        // 格式：192.168.1.64-192.168.1.127
        if (pattern.contains("-")) {
            String[] ips = pattern.split("-");
            if (ips.length == 2) {
                String[] starts = ips[0].split("\\.");
                String[] ends = ips[1].split("\\.");
                String[] cidrs = ip.split("\\.");
                boolean in = true;
                for (int i = 0; i < 4; i++) {
                    if (Integer.valueOf(cidrs[i].trim()) < Integer.valueOf(starts[i].trim())) {
                        in = false;
                        break;
                    }
                    if (Integer.valueOf(cidrs[i].trim()) > Integer.valueOf(ends[i].trim())) {
                        in = false;
                        break;
                    }
                }
                return in;
            }
        } else if (pattern.contains("/")) {

            // 格式：192.168.1.64/26
            String[] ips = ip.split("\\.");
            int ipAddr = (Integer.parseInt(ips[0]) << 24) | (Integer.parseInt(ips[1]) << 16) | (Integer.parseInt(ips[2]) << 8) | Integer.parseInt(ips[3]);
            int type = Integer.parseInt(pattern.replaceAll(".*/", ""));
            int mask = 0xFFFFFFFF << (32 - type);
            String cidrIp = pattern.replaceAll("/.*", "");
            String[] cidrIps = cidrIp.split("\\.");
            int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24) | (Integer.parseInt(cidrIps[1]) << 16) | (Integer.parseInt(cidrIps[2]) << 8) | Integer.parseInt(cidrIps[3]);
            return (ipAddr & mask) == (cidrIpAddr & mask);
        }
        return false;
    }

    /**
     * 设置请求参数对象.
     * 
     * @param request
     * @param obj
     */
    public static void setRequestObject(HttpServletRequest request, Object obj) {
        request.setAttribute(REQUEST_OBJECT, obj);
    }

    /**
     * 获取请求参数对象.
     * 
     * @param request
     * @return
     */
    public static Object getRequestObject(HttpServletRequest request) {
        return request.getAttribute(REQUEST_OBJECT);
    }
}
