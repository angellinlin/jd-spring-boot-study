package com.jincou.apollo.juejin.juejin5;

import cn.hutool.json.JSONUtil;

import java.util.concurrent.*;

/**
 * @author zhouguilong6
 * @date 2025/1/13 17:29
 */
public class AsyncInvoke {

    /**
     * 借助 CompletableFuture 来实现异步行为。
     * 不会抛出异常，在 onFailure 中处理异常
     *
     * @param executeTask
     * @param <R>
     * @return
     */
    private static <R> CompletableFuture<R> doInvoker(
            CallbackTask<R> executeTask) {
        CompletableFuture<R> invoke = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        return executeTask.execute();
                    } catch (Exception exception) {
                        throw new RuntimeException();
                    }
                },  Executors.newFixedThreadPool(2))
                .whenComplete((result, throwable) -> {
                    // 不管成功与失败，whenComplete 都会执行，
                    // 通过 throwable == null 跳过执行
                    if (throwable == null) {
                        executeTask.onSuccess(result);
                    }
                })
                .exceptionally(throwable -> {
                    executeTask.onFailure(throwable);
                    // todo 给一个默认值，或者使用 Optional包装一下，否者异常会出现NPE
                    return null;
                });
        return invoke;
    }


    public static void main(String[] args) {
        AsyncInvoke.doInvoker(new CallbackTask<Integer>() {
            public Integer execute()  {
                return 1/0;
            }

            @Override
            public void onSuccess(Integer integer) {
                System.out.println("on success result: " + integer);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("error " + t.getMessage());
            }
        });
    }


}
