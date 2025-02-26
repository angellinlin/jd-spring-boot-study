package com.jincou.validation.dynamic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author zhouguilong6
 * @date 2025/2/26 14:33
 */
@Configuration
public class DataSourceTransactionManagerConfig {
    @Bean
    public DataSourceTransactionManager transactionManager1(DynamicDataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager2(DynamicDataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
