package com.jincou.apollo.juejin.juejin7;

/**
 * @author zhouguilong6
 * @date 2025/1/16 17:02
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 一灯架构
 * @apiNote CountDownLatch测试类（场景1）
 **/
public class CountDownLatchTest1 {

    public static void main(String[] args) throws InterruptedException {

        // 1. 创建一个线程池，用来执行3个查询任务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 2. 创建一个计数锁，数量是3
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // 3. 启动3个查询任务
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                try {
                    // 4. 睡眠1秒，模拟任务执行过程
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + " 执行完成");
                    // 5. 任务执行完成，计数器减一
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                }
            });
        }
        // 6. 等待所有任务执行完成
        countDownLatch.await();
        System.out.println("所有任务执行完成。");

        // 7. 关闭线程池
        executorService.shutdown();
    }
}

