package com.jincou.apollo.juejin.juejin7;

/**
 * @author zhouguilong6
 * @date 2025/1/16 17:12
 */
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 一灯架构
 * @apiNote CyclicBarrier测试类
 **/
@Slf4j
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {

        // 1. 创建一个线程池，用来执行任务
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 2. 创建一个循环栅栏，线程数是3
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        // 3. 提交9个任务，刚好可以循环3轮
        for (int i = 0; i < 9; i++) {
            // 4. 睡眠100ms再提交任务，避免并发提交
            Thread.sleep(100);
            executorService.execute(() -> {
                try {
                    // 5. 睡眠1秒，模拟任务准备阶段
                    Thread.sleep(10000);
                    log.info(Thread.currentThread().getName() + " 准备 " + cyclicBarrier.getNumberWaiting());
                    // 6. 阻塞当前任务，直到3个线程都到达栅栏
                    cyclicBarrier.await();

                    log.info(Thread.currentThread().getName() + " 执行完成");
                } catch (Exception e) {
                }
            });
        }

        // 7. 关闭线程池
        executorService.shutdown();
    }
}

