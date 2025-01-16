package com.jincou.apollo.juejin.juejin7;

/**
 * @author zhouguilong6
 * @date 2025/1/16 16:54
 */
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author 一灯架构
 * @apiNote Semaphore测试类
 **/
@Slf4j
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {

        // 1. 创建一个线程池，用来执行10个任务
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 2. 创建一个信号量，许可数量是3
        Semaphore semaphore = new Semaphore(3);

        // 3. 启动10个任务
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    // 4. 执行任务之前，获取许可
                    semaphore.acquire();

                    // 5. 睡眠1秒，模拟任务执行过程
                    Thread.sleep(1000);
                    log.info(Thread.currentThread().getName() + " 执行完成");

                    // 6. 执行任务完成，释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                }
            });
        }

        // 7. 关闭线程池
        executorService.shutdown();
    }
}

