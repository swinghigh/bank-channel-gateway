package com.jkf.channel.gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiangyu
 * @date 2023/11/21 9:26
 */
@Configuration
public class BusinessConfig {

    public static String phonePrefix;//手机号的前缀

    @Value("${buss.phonePrefix}")
    public  void setPhonePrefix(String phonePrefix) {
        BusinessConfig.phonePrefix = phonePrefix;
    }
}
