package com.jincou.apollo.juejin.juejin6;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouguilong6
 * @date 2025/1/15 15:52
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @PostMapping(value = "/testForLogin")
    //以account为锁的key，限制每分钟最多登录5次
    @GlobalRateLimiter(key = "#params.account", rate = 5, rateInterval = 60)
    public String testForLogin() {
        //登录逻辑
        return "登录成功";
    }
}

