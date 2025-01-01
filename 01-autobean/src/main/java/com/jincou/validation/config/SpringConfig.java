package com.jincou.validation.config;


import com.jincou.validation.dynamic.DynamicDataSourcePlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhouguilong6
 * @date 2024/12/31 10:34
 */
//定义该类为Spring配置类
@Configuration
//开启切面
@EnableAspectJAutoProxy
//读取包下定义的Bean
@ComponentScan("com.jdd.fintech.megrez.loan.manager")
public class SpringConfig {
    @Bean
    public Interceptor dynamicDataSourcePlugin() {
        return new DynamicDataSourcePlugin();
    }
}

