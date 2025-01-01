package com.jincou.apollo.juejin.strategeImpl;

import cn.hutool.extra.spring.SpringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:07
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
@Getter
@AllArgsConstructor
public enum ESmsSendStatus implements IDictEnum {

    WAIT(0, "提交请求", SmsWaitEventHandle.class),
    SUCCESS(1, "发送成功", SmsSucceedEventHandle.class),
    FAILED(2, "发送失败", SmsFailedEventHandle.class),
    SENDING(3, "发送中", SmsSendingEventHandle.class),
    ;

    private final Integer type;
    private final String desc;
    private final Class<? extends ISmsEventHandler> clazz;

    public void handle(String msg) {
        SpringUtil.getBean(clazz).handle(msg);
    }
}

