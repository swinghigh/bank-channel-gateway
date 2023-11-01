package com.jkf.channel.gateway.filter;
import com.jkf.channel.gateway.utils.ClientUtils;
import com.jkf.channel.gateway.utils.IpUtils;
import com.jkf.channel.gateway.utils.ServletRequestUtils;
import com.jkf.channel.gateway.wrapper.BodyReaderHttpServletRequestWrapper;
import com.jkf.channel.gateway.wrapper.LoggingHttpServletResponseWrapper;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * 请求日志打印拦截
 */
public class LogFilter extends BaseBizFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
    }

    @Override
    public void doService(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put("transId", UUID.randomUUID().toString().replaceAll("-",""));
        long t1 = System.currentTimeMillis();
        StringBuilder mLog = new StringBuilder();
        //包装响应信息
        LoggingHttpServletResponseWrapper responseWrapper = new LoggingHttpServletResponseWrapper((HttpServletResponse) servletResponse, mLog);
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;

            // 判断是否不过滤
            if (!ServletRequestUtils.isFilter(request, allNotFilterUrls)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            // 判断是否不过滤
            if (!ServletRequestUtils.isFilter(request, notFilterUrls)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            // 使用commons-upload时，multipart请求需解析
            if (ClientUtils.isMultipart(request) && ClientUtils.isCommonsUpload()) {
                HttpServletRequest multipart = ClientUtils.resolveMultipart(request);
                if (null != multipart) {
                    servletRequest = multipart;
                }
            } else if (!ServletRequestUtils.isInstanceof(request, BodyReaderHttpServletRequestWrapper.class)) {
                // 非表单传递
                if (!ClientUtils.isForm(request) && !ClientUtils.isMultipart(request)) {
                    // 非multipart请求才需封装request，用于读取在输入流中的请求字符串
                    servletRequest = new BodyReaderHttpServletRequestWrapper(request);
                }
                String contentType = request.getContentType();
                if(!ServletRequestUtils.isInstanceof(servletRequest, BodyReaderHttpServletRequestWrapper.class)&&(contentType==null||contentType.contains("json"))){
                    servletRequest = new BodyReaderHttpServletRequestWrapper(request);
                }
            }
        } else {
            // 防止数据流只能读取一次
          /*  if (!ServletRequestUtils.isInstanceof(servletRequest, BodyReaderHttpServletRequestWrapper.class)) {
                servletRequest = new BodyReaderHttpServletRequestWrapper(servletRequest);
            }*/
        }
        try {
            filterChain.doFilter(servletRequest, responseWrapper);

            if(ServletRequestUtils.isInstanceof(servletRequest, BodyReaderHttpServletRequestWrapper.class)) {
                BodyReaderHttpServletRequestWrapper request = (BodyReaderHttpServletRequestWrapper) servletRequest;
                // 获取流中数据
                String params = readIncommingRequestData(request);
                if (StringUtils.isEmpty(params)) {
                    Map<String, String> reqestParamMap = getRequestAll(request);
                    params = (reqestParamMap == null ? "" : reqestParamMap.toString());
                }
                String url = request.getRequestURL().toString();
                String debugInfo = "请求端IP：" + IpUtils.getIpAddress(request) + "请求地址：" + url + "  ";
                if (url.indexOf("data_upload") < 0) {
                    debugInfo += "\n请求参数：" + params;
                }
                debugInfo += "\n返回值：" + mLog.toString();
                long t2 = System.currentTimeMillis();
                debugInfo += " 收到请求时间:" + t1 + " 响应时间点:" + t2 + " 请求耗时：" + (t2 - t1) + "ms ";
                logger.info(debugInfo);
            }
        } catch (Exception e) {
            logger.error("出现异常", e);;
        }
    }

    private String readIncommingRequestData(HttpServletRequest request) {
        BufferedReader br = null;

        try {
            StringBuilder e = new StringBuilder();
            br = request.getReader();
            String line = null;

            while ((line = br.readLine()) != null) {
                e.append(line).append("\n");
            }

            line = e.toString();
            return line;
        } catch (IOException var12) {
            throw new RuntimeException(var12);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException var11) {
                    var11.printStackTrace();
                }
            }
        }
    }

    private Map<String, String> getRequestAll(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        return params;
    }

}
