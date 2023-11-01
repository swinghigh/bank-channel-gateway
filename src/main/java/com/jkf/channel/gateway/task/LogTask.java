package com.jkf.channel.gateway.task;

import com.jkf.channel.gateway.constant.RedisConstants;
import com.jkf.channel.gateway.dao.RequestLogMapper;
import com.jkf.channel.gateway.entity.RequestLog;
import com.jkf.channel.gateway.utils.JsonUtils;
import com.jkf.channel.gateway.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xiangyu
 * @date 2023/11/1 11:15
 */
@Configuration
@EnableScheduling
@Slf4j
public class LogTask {
   /* @Resource
    private RedisTemplate<String, String> redisTemplate;*/
   @Resource
   private RequestLogMapper requestLogMapper;
    /**
     * 每隔30秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {
        //将redis中的数据保存到数据库
        /*long timeMillis = System.currentTimeMillis();
        ZSetOperations<String, String> set = RedisUtil.getZSetOperations();
        //获取缓存中的数据,获取比当前排序值小的数据取出来
        Set<String> list = set.rangeByScore(RedisConstants.REDIS_KEY_LOG, 0, timeMillis);
        if (ObjectUtils.isEmpty(list)) {
            return;
        }
        for ()*/
        Set<String> set=RedisUtil.getZSet(RedisConstants.REDIS_KEY_LOG);
        if(!set.isEmpty()) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String info = it.next();
                //移除
                RedisUtil.removeZSet(RedisConstants.REDIS_KEY_LOG, info);
                //保存
                try {
                    RequestLog requestLog = JsonUtils.jsonToObject(info, RequestLog.class);
                    requestLogMapper.insert(requestLog);
                }catch (Exception e){
                    log.error("保存失败:{}",info,e);
                }
            }
        }
    }
}
