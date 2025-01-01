package com.jincou.apollo.juejin.strategeImpl;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:07
 */
public interface ISmsService {
    /**
     * 发送短信
     * @param msg 短信内容
     */
    void send(String msg, Integer status);
}

