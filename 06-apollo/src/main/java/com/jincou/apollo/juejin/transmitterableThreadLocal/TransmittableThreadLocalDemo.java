package com.jincou.apollo.juejin.transmitterableThreadLocal;

/**
 * @author zhouguilong6
 * @date 2025/1/3 15:39
 */

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalDemo {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 创建TransmittableThreadLocal实例
        TransmittableThreadLocal<Integer> threadLocal = new TransmittableThreadLocal<>();

        // 在主线程设置值
        threadLocal.set(42);
        System.out.println("主线程 - ThreadLocal value: " + threadLocal.get());

        // 提交任务到线程池
        executorService.execute(() -> {
            // 打印子线程中的ThreadLocal值
            System.out.println("子线程 - ThreadLocal value: " + threadLocal.get());
        });

        // 关闭线程池
        executorService.shutdown();
    }
}
