package com.jincou.apollo.juejin.strategeImpl;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:01
 */
public abstract class AbstractSmsStatusEventHandle implements ISmsEventHandler {
    /**
     * 处理短信
     *
     * @param msg 短信内容
     */
    @Override
    public void handle(String msg) {
        // 这里定义公共操作

        // 这里调用子类处理方法
        handleEvent(msg);
    }

    /**
     * 处理短信
     *
     * @param msg 短信内容
     */
    protected abstract void handleEvent(String msg);
}
