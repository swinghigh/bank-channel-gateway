package com.jkf.channel.gateway.filter;
import com.jkf.channel.gateway.utils.ClientUtils;
import com.jkf.channel.gateway.utils.ServletRequestUtils;
import com.jkf.channel.gateway.wrapper.BodyReaderHttpServletRequestWrapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * The class BaseBizFilter.
 * <p>
 * Description:
 *
 * @author: wuweikun
 * @since: 2020/04/18
 */

public abstract class BaseBizFilter implements Filter {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 关
     */
    private static final String OFF = "0";

    /**
     * jsonp回调函数名称配置
     */
    protected static final String CALLBACK_NAME = "callbackName";

    protected static final String RESULT_CODE_NAME = "resultCodeName";

    protected static final String ERROR_DESC_NAME = "errorDescName";
    /**
     * 不过滤的地址参数名
     */
    protected static final String NOT_FILTER_URL = "notFilterURL";

    /**
     * 配置所有不过滤的开关（1：开，0：关，默认开）
     */
    protected static final String ALL_NOT_FILTER_FLAG = "allNotFilterFlag";

    /**
     * jsonp回调参数名
     */
    protected String callbackName = "callback";

    /**
     * 不过滤的地址数组（所有filter都不过滤）
     */
    protected String[] allNotFilterUrls = null;

    /**
     * 不过滤的地址数组
     */
    protected String[] notFilterUrls = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        String callbackName = config.getServletContext().getInitParameter(CALLBACK_NAME);
        if (StringUtils.isNotBlank(callbackName)) {
            this.callbackName = callbackName;
        }
        // 全局不过滤的地址
        String allNotFilterUrl = config.getServletContext().getInitParameter(NOT_FILTER_URL);

        // 全局不过滤开关
        String allNotFilterFlag = config.getInitParameter(ALL_NOT_FILTER_FLAG);
        if (!OFF.equals(allNotFilterFlag) && StringUtils.isNotBlank(allNotFilterUrl)) {

            // 以逗号分隔
            allNotFilterUrls = allNotFilterUrl.split(",");
            for (int i = 0; i < allNotFilterUrls.length; i++) {
                allNotFilterUrls[i] = allNotFilterUrls[i].trim();
            }
        }

        // 不过滤的地址
        String notFilterUrl = config.getInitParameter(NOT_FILTER_URL);
        logger.debug("配置不过滤的地址为{}", notFilterUrl);
        if (StringUtils.isNotBlank(notFilterUrl)) {
            // 以逗号分隔
            notFilterUrls = notFilterUrl.split(",");
            for (int i = 0; i < notFilterUrls.length; i++) {
                notFilterUrls[i] = notFilterUrls[i].trim();
            }
        }
        // 做初始化操作
        doInit(config);
    }

    /**
     * 定制初始化
     * 
     * @param config
     */
    protected void doInit(FilterConfig config) {

    };

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;
            // 判断是否不过滤
            if (!ServletRequestUtils.isFilter(request, allNotFilterUrls)) {
                chain.doFilter(req, resp);
                return;
            }
            // 判断是否不过滤
            if (!ServletRequestUtils.isFilter(request, notFilterUrls)) {
                chain.doFilter(req, resp);
                return;
            }
            // 使用commons-upload时，multipart请求需解析
            if (ClientUtils.isMultipart(request) && ClientUtils.isCommonsUpload()) {
                HttpServletRequest multipart = ClientUtils.resolveMultipart(request);
                if (null != multipart) {
                    req = multipart;
                }
            } else if (!ServletRequestUtils.isInstanceof(request, BodyReaderHttpServletRequestWrapper.class)) {

                // 非表单传递
                if (!ClientUtils.isForm(request) && !ClientUtils.isMultipart(request)) {
                    // 非multipart请求才需封装request，用于读取在输入流中的请求字符串
                    req = new BodyReaderHttpServletRequestWrapper(request);
                }
                String contentType = request.getContentType();
                if(!ServletRequestUtils.isInstanceof(req, BodyReaderHttpServletRequestWrapper.class)&&(contentType==null||contentType.contains("json"))){
                    req = new BodyReaderHttpServletRequestWrapper(request);
                }
            }
        } else {

            // 防止数据流只能读取一次
           /* if (!ServletRequestUtils.isInstanceof(req, BodyReaderHttpServletRequestWrapper.class)) {
                req = new BodyReaderHttpServletRequestWrapper(req);
            }*/
        }

        // 实际业务处理
        doService(req, resp, chain);
    }

    /**
     * 实际业务处理
     * 
     * @param req
     * @param resp
     * @param chain
     */
    protected abstract void doService(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException;

    @Override
    public void destroy() {
    }
}
