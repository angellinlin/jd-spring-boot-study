package com.jincou.apollo.juejin;
import com.jincou.apollo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.CompletableFuture;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CompletableFutureTest {
    @Test
    public void test02() {
        Runnable run1 = () -> {
            // 模拟耗时
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run1");
        };
        Runnable run2 = () -> {
            // 模拟耗时
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run2");
        };
        Runnable run3 = () -> {
            // 模拟耗时
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run3");
        };
        Runnable run4 = () -> {
            // 模拟耗时
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run4");
        };

        CompletableFutureSimpleThreadPool.executeTasks(run1, run2, run3, run4);
        System.out.println("test02 执行完毕");
    }

    @Test
    public void test03() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(CompletableFutureTest::getData1);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(CompletableFutureTest::getData2);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(CompletableFutureTest::getData3);
        List<String> res = CompletableFutureSimpleThreadPool.executeCompletableFutures(future1, future2, future3);
        System.out.println(res);
        System.out.println("test03 执行完毕");
    }

    @Test
    public void test04() {
        List<String> res = CompletableFutureSimpleThreadPool.executeSuppliers(CompletableFutureTest::getData1, CompletableFutureTest::getData2, CompletableFutureTest::getData3);
        System.out.println(res);
        System.out.println("test04 执行完毕");
    }



    public static String getData1() {
        // 模拟耗时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("data1执行完毕");
        return "data1";
    }

    public static String getData2() {
        // 模拟耗时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("data2执行完毕");
        return "data2";
    }

    public static String getData3() {
        // 模拟耗时
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("data3执行完毕");
        return "data3";
    }
}
