package com.jincou.apollo.juejin.juejin10;

/**
 * @author zhouguilong6
 * @date 2025/2/11 20:12
 */
import java.util.concurrent.Semaphore;

public class SemaphorePrint {
    private static int state = 0;

    // 三个信号量对象，分别表示A、B、C三个线程的初始许可数
    private static final Semaphore A = new Semaphore(1);
    private static final Semaphore B = new Semaphore(0);
    private static final Semaphore C = new Semaphore(0);

    public static void main(String[] args) {
        // 创建三个线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 循环100次
                    for (int i = 0; i < 100; i++) {
                        // 获取许可
                        A.acquire();
                        // 打印字母
                        System.out.println("A");
                        // 修改状态
                        state++;
                        // 释放许可
                        B.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        B.acquire();
                        System.out.println("B");
                        state++;
                        C.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        C.acquire();
                        System.out.println("C");
                        state++;
                        A.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动三个线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

