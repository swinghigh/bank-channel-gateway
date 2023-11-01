package com.jkf.channel.gateway.utils;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 * @author puyiliang
 * @date create in 2021/3/3 15:28
 */
public class ThreadPoolUtil {
    /**
     * 创建定时任务线程池
     * 核心线程 10 最大线程150 线程存活时间0秒 先进先出序列
     */
    public static ExecutorService callbackThreadPool = new ThreadPoolExecutor(10, 150,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNamePrefix("callback-merchant-pool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());
}
