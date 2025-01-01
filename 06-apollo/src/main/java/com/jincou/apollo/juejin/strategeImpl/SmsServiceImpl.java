package com.jincou.apollo.juejin.strategeImpl;

import org.springframework.stereotype.Service;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:07
 */
@Service
public class SmsServiceImpl implements ISmsService {
    /**
     * 发送短信
     *
     * @param msg    短信内容
     * @param status
     */
    @Override
    public void send(String msg, Integer status) {
        IDictEnum.getEnum(status, ESmsSendStatus.class).handle(msg);
    }
}
