package com.jincou.apollo.juejin.transmitterableThreadLocal;

/**
 * @author zhouguilong6
 * @date 2025/1/3 15:39
 */

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalDemo {
    public static void main(String[] args) throws Exception {
        test2();
    }

    public static void test1() throws Exception {
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
    public static void test3() throws Exception {
        //单一线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //ThreadLocal存储
        ThreadLocal<String> username = new ThreadLocal<>();
        username.set("为了岩王帝君");
        Thread.sleep(3000);
        new Thread(()-> System.out.println(username.get()+" 1")).start();
        for (int i = 0; i < 2; i++) {
            CompletableFuture.runAsync(() -> System.out.println(username.get() + " 2"), executorService);
        }
        Thread.sleep(3000);
        System.out.println(username.get()+" 3");
        executorService.shutdown();
    }

    public static void test2() throws Exception {
        //单一线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //InheritableThreadLocal存储
        InheritableThreadLocal<String> name = new InheritableThreadLocal<>();
        for (int i = 0; i < 5; i++) {
            name.set("为了岩王帝君"+i);
            Thread.sleep(3000);
            new Thread(()-> System.out.println(name.get()+" 斩尽牛杂")).start();
            CompletableFuture.runAsync(()-> System.out.println(name.get()),executorService);
        }
        name.remove();
        Thread.sleep(3000);
        System.out.println("---------------");
        CompletableFuture.runAsync(()-> System.out.println(name.get()+" 天动万象"),executorService);
        executorService.shutdown();
    }

}
