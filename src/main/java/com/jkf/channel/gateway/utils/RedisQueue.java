package com.jkf.channel.gateway.utils;

import com.jkf.channel.gateway.constant.RedisConstants;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Iterator;
import java.util.Set;

/**
 * redis队列
 * @author xiangyu
 * @date 2023/12/5 20:02
 */
public class RedisQueue {

    /**
     * 加入队列
     * @param key
     * @param value
     * @param delayTime 延迟的时间
     */
    public static void push(String key,String value,long delayTime){
        RedisUtil.zset(key,System.currentTimeMillis()+delayTime,value);
    }

    /**
     *
     * @param key 队列
     * @param count 获取的条数
     * @return
     */
    public static Set<String>  pop(String key,Integer count){
        ZSetOperations<String, String> set = RedisUtil.getZSetOperations();
        Set<String> list = set.rangeByScore(key, 0, System.currentTimeMillis(),0,count);
        if (list!=null&&list.size()>0){
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String info = it.next();
                //移除
                RedisUtil.removeZSet(key, info);
            }
        }
        return list;
    }
}
