package com.jkf.channel.gateway.task;

import com.jkf.channel.gateway.constant.RedisConstants;
import com.jkf.channel.gateway.entity.RequestLog;
import com.jkf.channel.gateway.service.IBussinessNotifyService;
import com.jkf.channel.gateway.utils.JsonUtils;
import com.jkf.channel.gateway.utils.RedisUtil;
import com.jkf.channel.gateway.vo.NotifyVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ObjectUtils;

import java.util.Iterator;
import java.util.Set;

/**
 * 处理通知队列中的数据
 * @author xiangyu
 * @date 2023/12/4 20:54
 */
@Configuration
@EnableScheduling
@Slf4j
public class RedisNotifyQuenTask {

    @Autowired
    private IBussinessNotifyService bussinessNotifyService;
    /**
     * 每隔30秒执行一次
     * 处理redis 通知队列中的数据
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {
        //将redis中的数据保存到数据库
        long timeMillis = System.currentTimeMillis();
        ZSetOperations<String, String> set = RedisUtil.getZSetOperations();
        //获取缓存中的数据,获取比当前排序值小的数据取出来
        Set<String> list = set.rangeByScore(RedisConstants.REDIS_NOTIFY_SET, 0, timeMillis);
        if (ObjectUtils.isEmpty(list)) {
            return;
        }
        if(!list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String info = it.next();
                //移除
                RedisUtil.removeZSet(RedisConstants.REDIS_NOTIFY_SET, info);
                //保存
                try {
                    NotifyVo notifyVo = JsonUtils.jsonToObject(info, NotifyVo.class);
                    bussinessNotifyService.busNotify(notifyVo);
                }catch (Exception e){
                    log.error("保存失败:{}",info,e);
                }
            }
        }
    }
}
