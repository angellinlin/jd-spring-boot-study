package com.jincou.apollo.juejin.strategeImpl;

import org.springframework.stereotype.Component;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:02
 */
@Component
public class SmsWaitEventHandle extends AbstractSmsStatusEventHandle {
    /**
     * 处理短信
     *
     * @param msg 短信内容
     */
    @Override
    protected void handleEvent(String msg) {
        // 这里是处理短信等待中逻辑
        System.out.println("这里是短信提交请求中逻辑：" + msg);
    }
}

