package com.jincou.apollo;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: Springboot 启动类
 *
 * @author xub
 * @date 2019/6/11 下午12:42
 */
@SpringBootApplication
@EnableApolloConfig
@ComponentScan(basePackages = {"com.jincou.apollo.juejin"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}


