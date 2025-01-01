package com.jincou.apollo.juejin.strategeImpl;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:01
 */
public interface ISmsEventHandler {
    /**
     * 处理短信
     *
     * @param msg 短信内容
     */
    void handle(String msg);
}

