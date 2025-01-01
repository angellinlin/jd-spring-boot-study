package com.jincou.validation.dynamic;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author zhouguilong6
 * @date 2025/1/1 16:15
 */
@Intercepts(
        {@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class,
                        ResultHandler.class})})//在Mybatis中对操作的分类分为两种（update：增删改）（query：查）
public class DynamicDataSourcePlugin implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourcePlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("类完整路径is: " + invocation.getTarget().getClass());
        logger.info("类方法is: " + invocation.getMethod());

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String mappedStatementId = mappedStatement.getId();
        Class<?> mapperClazz = Class.forName(mappedStatementId.substring(0,mappedStatementId.lastIndexOf(".")));
        DataSource dataSource = mapperClazz.getAnnotation(DataSource.class);
//        DataSource dataSource = invocation.getMethod().getAnnotation(DataSource.class);
        // 通过判断 DataSource 中的值来判断当前方法应用哪个数据源
        DynamicDataSource.setDataSource(dataSource.value());
        logger.info("set datasource is " + dataSource.value());
        try {
            return invocation.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.info("clean datasource");
        }
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
