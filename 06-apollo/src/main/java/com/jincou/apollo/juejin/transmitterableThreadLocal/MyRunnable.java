package com.jincou.apollo.juejin.transmitterableThreadLocal;

/**
 * @author zhouguilong6
 * @date 2025/1/3 15:14
 */

import com.alibaba.ttl.TransmittableThreadLocal;

public class MyRunnable implements Runnable {
    private static final TransmittableThreadLocal<Integer> threadLocal = new TransmittableThreadLocal<>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100)); // 设置当前线程的值
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TransmittableThreadLocal value: " + threadLocal.get()); // 获取当前线程的值
    }
}
