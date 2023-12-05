package com.jkf.channel.gateway.task;

import com.jkf.channel.gateway.handler.NotifyService;
import com.jkf.channel.gateway.handler.SystemInitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 通知任务
 */

@Slf4j
@Component
public class NotifyTask {

    @Autowired
    private NotifyService notifyService;

    /**
     * 每隔30秒执行一次
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void task() {
        notifyService.noticeOrderNotifyLog();
    }
}
