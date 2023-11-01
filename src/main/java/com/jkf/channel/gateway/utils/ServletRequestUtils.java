package com.jkf.channel.gateway.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xiangyu
 * @date 2023/2/15 17:31
 */
public class ServletRequestUtils {
    /**
     * 判断request是否是指定的类
     *
     * @param request
     *
     * @param requestClazz
     *            指定类
     *
     * @return
     */
    public static <T extends ServletRequest> boolean isInstanceof(ServletRequest request, Class<T> requestClazz) {
        if (null != request && requestClazz.isAssignableFrom(request.getClass())) {
            return true;
        }

        // 是否已包装标志
        boolean flag = false;

        ServletRequest origRequest = request;

        // 防止重复包装
        while (null != origRequest && origRequest instanceof ServletRequestWrapper && origRequest != ((ServletRequestWrapper) origRequest).getRequest()) {
            origRequest = ((ServletRequestWrapper) origRequest).getRequest();
            if (null != origRequest && requestClazz.isAssignableFrom(origRequest.getClass())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 判断请求是否过滤
     *
     * @param request
     * @param notFilterUrls
     *            不过滤地址数组
     *
     * @return
     */
    public static boolean isFilter(HttpServletRequest request, String[] notFilterUrls) {
        if (null != notFilterUrls && notFilterUrls.length > 0) {
            String requestPath = RequestUtils.getRequestPath(request);
            for (String url : notFilterUrls) {
                if (RequestUtils.isMatch(requestPath, url)) {
                    return false;
                }
            }
        }
        return true;
    }
}
