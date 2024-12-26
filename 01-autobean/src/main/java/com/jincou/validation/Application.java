package com.jincou.validation;


import com.jd.jr.cf.ledger.integration.common.consts.Defaults;
import com.jincou.validation.dynamic.DynamicDataSourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 动态数据源配置,需要将自有的配置依赖(DynamicDataSourceConfig),将原有的依赖去除(DataSourceAutoConfiguration)
 * @author geYang
 * @date 2018-05-15
 */
@Slf4j
@Import({DynamicDataSourceConfig.class})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.jincou.validation.dao")
@ImportResource("classpath:config/*.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
