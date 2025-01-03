package com.jincou.apollo.juejin.transmitterableThreadLocal;

/**
 * @author zhouguilong6
 * @date 2025/1/3 15:15
 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: csh
 * @Date: 2023/7/8 20:37
 * @Description:
 * ttl案例，通过 线程池，将上一个线程带给下一线程。
 *
 */
public class StudyTtl {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MyRunnable sharedRunnable = new MyRunnable();

        executorService.execute(sharedRunnable);
        executorService.execute(sharedRunnable);

        executorService.shutdown();
    }
}
