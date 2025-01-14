package com.jincou.apollo.juejin.juejin5;

/**
 * @author zhouguilong6
 * @date 2025/1/13 17:28
 */
public interface CallbackTask<R> {
    R execute();
    default void onSuccess(R r) {
    }
    default void onFailure(Throwable t) {
    }
}

