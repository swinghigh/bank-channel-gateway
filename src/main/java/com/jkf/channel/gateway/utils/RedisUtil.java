package com.jkf.channel.gateway.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.types.Expiration;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@Configuration
public class RedisUtil {
    private static Logger logger= LoggerFactory.getLogger(RedisUtil.class);

    //https://blog.csdn.net/lydms/article/details/105224210
    private static RedisTemplate redisTemplate;
   /* @Resource
    private RedisTemplate redisTemplate;*/
    public static void setRedisTemplate(RedisTemplate redisTemplateOrg){
        redisTemplate=redisTemplateOrg;
    }

    public static ZSetOperations<String, String> getZSetOperations(){
        return redisTemplate.opsForZSet();
    }

    //删除单个key
    public static void delede(String key){
        redisTemplate.delete(key);
    }

    //删除多个key
    public static void deleteKey (String...keys){
        redisTemplate.delete(keys);
    }

    //放入String
    public static void putString(String key, String value){
        redisTemplate.boundValueOps(key).set(value);
    }

    //放入String
    public static void putString(String key, String value, int num){
        redisTemplate.boundValueOps(key).set(value,num, TimeUnit.MINUTES);
    }

    public static String getString(String key){
        return (String) redisTemplate.boundValueOps(key).get();
    }

    public static void putMap(String key, Map map){
        redisTemplate.boundHashOps(key).putAll(map);
    }

    public static Map<String, Object> getMap(String key){
        return redisTemplate.boundHashOps(key).entries();
    }

    public static Object getValue(String key, String small_key){
        return redisTemplate.boundHashOps(key).get(small_key);
    }

    public static boolean hasKey(String key, String small_key){
        return redisTemplate.boundHashOps(key).hasKey(small_key);
    }

    public static void putList(String key, List list){
        redisTemplate.boundListOps(key).leftPushAll(list);
    }

    public static List getList(String key, int start, int end){
        return redisTemplate.boundListOps(key).range(start, end);
    }

    public static void zset(String key, double score, String value){
//        redisTemplate.boundZSetOps(key).add(value,score);
        redisTemplate.opsForZSet().add(key,value,score);
    }

    public static Set<String> getZSet(String key){
        return redisTemplate.boundZSetOps(key).range(0, -1);
    }

    public static Double getScore(String key, String value){
        return redisTemplate.boundZSetOps(key).score(value);
    }

    public static void removeZSet(String key, String value){
        redisTemplate.boundZSetOps(key).remove(value);
    }

    public static void addScore(String key, String value, double socre){
        redisTemplate.boundZSetOps(key).incrementScore(value,socre);
    }

    public static boolean setNx(String key, String value, long expires, TimeUnit timeUnit) {
        boolean flag = false;
        try {
            flag = (boolean) redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.set(key.getBytes(), value.getBytes(), Expiration.from(expires, timeUnit), RedisStringCommands.SetOption.ifAbsent()));
        } catch (Exception e) {
            logger.error("设置缓存异常, key = {}", key, e);
        }
        return flag;
    }
}
