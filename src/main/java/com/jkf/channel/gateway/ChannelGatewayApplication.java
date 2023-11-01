package com.jkf.channel.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiangyu
 * @date 2023/10/27 17:25
 */
@MapperScan("com.jkf.channel.gateway.dao")
@SpringBootApplication
public class ChannelGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChannelGatewayApplication.class, args);
        System.out.println("启动成功！");
    }
}
