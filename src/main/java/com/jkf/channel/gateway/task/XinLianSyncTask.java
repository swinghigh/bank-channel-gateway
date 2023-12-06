package com.jkf.channel.gateway.task;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.jkf.channel.gateway.handler.ReconcileService;
import com.jkf.channel.gateway.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 信联同步任务
 * 目前 对账文件同步任务和对账任务
 */

@Slf4j
@Component
public class XinLianSyncTask {

    @Autowired
    private ReconcileService reconcileService;

    /**
     * 同步信联对账文件 付款和结算
     * 每天1点执行一次
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void downloadXinLianFileTask() {
        String taskName = "downloadXinLianFileTask";
        try {
            //昨天
            DateTime dateTime = DateUtil.offsetDay(new Date(), -1);
            String yestday = DateUtil.format(dateTime, "yyyyMMdd");
            String key = taskName + ":" + yestday;
            boolean checkPayOrder = RedisUtil.setNx(key, "1", 10, TimeUnit.MINUTES);
            if (checkPayOrder) {
                reconcileService.downloadXinLianFile(yestday);
            } else {
                log.info("已有服务再执行");
            }
        } catch (Exception e) {
            log.error(taskName + "同步对账文件（下载）任务异常", e);
        }

    }

    /**
     * 依据信联对账文件 进行对账
     * 每天1点30执行一次
     */
    @Scheduled(cron = "0 30 1 * * ?")
    public void xinLianReconcileTask() {
        String taskName = "xinLianReconcileTask";
        try {
            //昨天
            DateTime dateTime = DateUtil.offsetDay(new Date(), -1);
            String yestday = DateUtil.format(dateTime, "yyyyMMdd");
            String key = taskName + ":" + yestday;
            boolean reconcile = RedisUtil.setNx(key, "1", 10, TimeUnit.MINUTES);
            if (reconcile) {
                reconcileService.xinLianReconcile(yestday);
            } else {
                log.info("已有服务再执行");
            }
        } catch (Exception e) {
            log.error(taskName + "对账任务异常", e);
        }

    }
}
