package com.jkf.channel.gateway.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xiangyu
 * @date 2023/2/15 17:33
 */
public class RequestUtils {
    private static final Logger LOG = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * 请求json.
     */
    private static final String REQUEST_STREAM = RequestUtils.class.getName() + ".request_stream";

    /**
     * 获取请求Path
     *
     * @param request
     * @return
     */
    public static String getRequestPath(HttpServletRequest request) {
        String requestPath = "";
        String requestUri = request.getRequestURI();
        if (StringUtils.isNotBlank(requestUri)) {
            String contextPath = request.getContextPath();
            if (StringUtils.isNotBlank(contextPath)) {
                int index = requestUri.indexOf(contextPath);
                if (index > -1) {
                    requestPath = requestUri.substring(index + contextPath.length());
                }
            } else {
                requestPath = requestUri;
            }
        }
        if (StringUtils.isBlank(requestPath)) {
            requestPath = request.getServletPath();
        }

        if (StringUtils.isNotBlank(requestPath)) {
            if (requestPath.startsWith("/")) {
                requestPath = requestPath.substring(1);
            }
        }
        return requestPath;
    }

    /**
     * 获取请求流字符串
     *
     * @param request
     *
     * @param encoding
     *            编码
     * @return
     */
    public static String getRequestStream(HttpServletRequest request, String encoding) {
        // 请求流字符串
        String streamString = "";

        Object streamObj = request.getAttribute(REQUEST_STREAM);
        if (null != streamObj && streamObj instanceof String) {
            return (String) streamObj;
        }

        // 请求数据非空
        int contentLength = request.getContentLength();
        if (contentLength > 0) {
            BufferedReader reader = null;
            try {

                if (StringUtils.isNotBlank(encoding)) {
                    request.setCharacterEncoding(encoding);
                }

                InputStream is = request.getInputStream();
                if (null != is) {
                    if (is.markSupported() && is.available() > 0) {
                        is.mark(is.available());
                    }
                    reader = new BufferedReader(new InputStreamReader(is));

                    // 将返回结果转换为 String字符串
                    String line;
                    StringBuffer buffer = new StringBuffer();
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }
                    if (is.markSupported() && is.available() > 0) {
                        is.reset();
                    }
                    streamString = buffer.toString();

                    // 存储在request中
                    request.setAttribute(REQUEST_STREAM, streamString);
                }
            } catch (IOException e) {
                LOG.error("读取请求输入流失败！", e);
            }
        }
        return streamString;
    }

    /**
     * 路径是否匹配
     *
     * @param requestPath
     *            请求Path
     *
     * @param pattern
     *            Path模式
     *
     * @return 匹配结果(true:匹配，false:不匹配)
     */
    public static boolean isMatch(String requestPath, String pattern) {
        if (requestPath.equals(pattern)) {
            return true;
        } else {
            if (pattern.startsWith("/")) {
                pattern = pattern.substring(1);
            }

            // 针对pattern带？的处理
            int patternQmIndex = pattern.indexOf("?");
            if (patternQmIndex > -1) {

                // 如果后缀格式为abc=xxx，则
                String suffix = pattern.substring(patternQmIndex + 1);
                if (suffix.matches("[\\w$]+=[\\S\\s]+")) {

                    // requestPath不带？，则不相同
                    int pathQmIndex = requestPath.indexOf("?");
                    if (pathQmIndex <= -1) {
                        return false;
                    }
                    return isMatch(requestPath.substring(0, pathQmIndex), pattern.substring(0, patternQmIndex))
                            && isMatch(requestPath.substring(pathQmIndex + 1), pattern.substring(patternQmIndex + 1));
                }
            }
            return AntPathMatcher.match(pattern, requestPath);
        }
    }
}
