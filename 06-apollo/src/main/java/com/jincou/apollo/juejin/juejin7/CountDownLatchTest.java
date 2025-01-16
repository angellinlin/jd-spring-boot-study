package com.jincou.apollo.juejin.juejin7;

/**
 * @author zhouguilong6
 * @date 2025/1/16 16:59
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 一灯架构
 * @apiNote CountDownLatch测试类（场景2）
 **/
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        // 1. 创建一个线程池，用来执行3个任务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 2. 创建一个计数锁，数量是1
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 3. 启动3个任务
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 启动完成");
                    // 4. 等待其他任务启动完成
                    countDownLatch.await();
                    // 5. 睡眠1秒，模拟任务执行过程
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + " 执行完成");
                } catch (InterruptedException e) {
                }
            });
        }
        System.out.println("所有任务启动完成，开始执ddddddd行。");
        // 6. 所有任务启动完成，计数器减一
        countDownLatch.countDown();
        System.out.println("所有任务启动完成，开始执行。");

        // 7. 关闭线程池
        executorService.shutdown();
    }
}

