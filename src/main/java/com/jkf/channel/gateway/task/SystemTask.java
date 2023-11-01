package com.jkf.channel.gateway.task;

import com.jkf.channel.gateway.handler.SystemInitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 系统任务
 * @author xiangyu
 * @date 2023/10/31 11:22
 */
@Configuration
@EnableScheduling
@Slf4j
public class SystemTask {

    @Autowired
    private SystemInitService systemInitService;

    /**
     * 每隔10分钟执行一次
     */
    @Scheduled(cron = "0 0/10 * * * ?")
    public void task() {
        systemInitService.reflush();
    }
}
