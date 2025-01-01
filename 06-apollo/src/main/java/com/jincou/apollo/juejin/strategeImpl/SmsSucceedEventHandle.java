package com.jincou.apollo.juejin.strategeImpl;

import org.springframework.stereotype.Component;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:03
 */
@Component
public class SmsSucceedEventHandle extends AbstractSmsStatusEventHandle {
    /**
     * 处理短信
     *
     * @param msg 短信内容
     */
    @Override
    protected void handleEvent(String msg) {
        // 这里是处理短信成功的逻辑
        System.out.println("这里是短信发送成功的逻辑：" + msg);
    }
}

