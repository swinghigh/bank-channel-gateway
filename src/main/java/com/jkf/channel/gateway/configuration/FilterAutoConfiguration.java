package com.jkf.channel.gateway.configuration;
import com.jkf.channel.gateway.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.CollectionUtils;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * 过滤器注册
 * @author xiangyu
 * @date 2023/2/15 18:42
 */
@Configuration
public class FilterAutoConfiguration {

    @Bean(name="logFilter")
    public LogFilter sysVisitFilter(){
        return new LogFilter();
    }

    @Bean
    public FilterRegistrationBean logFilterRegistration( LogFilter logFilter) {
        String[] urlPatterns=new String[]{"/*"};
        Map<String,String> param=new HashMap<>();
        param.put("notFilterURL","/test/*");
        return filterRegistration(logFilter,"logFilter","highest",0,urlPatterns,param);
    }

    /**
     * 过滤器公共配置
     */
    private FilterRegistrationBean filterRegistration(Filter filter, String name, String orderKey,int orderFilter, String[] urlPatterns, Map<String,String> param) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);

        registration.setName(name);
        registration.addUrlPatterns(urlPatterns);
        if (!CollectionUtils.isEmpty(param)) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                registration.addInitParameter(entry.getKey(), entry.getValue());
            }
        }
        // 根据yml文件配置，计算order
        int order = "lowest".equals(orderKey) ? Ordered.LOWEST_PRECEDENCE : Ordered.HIGHEST_PRECEDENCE;
        registration.setOrder(order + orderFilter);//从小到大的顺序来依次过滤
        return registration;
    }
}
