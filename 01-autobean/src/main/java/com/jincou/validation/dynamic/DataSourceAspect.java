package com.jincou.validation.dynamic;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源AOP切面处理
 * @author zhouguilong6
 * @date 2024/12/25 15:50
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 切点: 所有配置 DataSource 注解的方法
     */
    @Pointcut("@annotation(com.jincou.validation.dynamic.DataSource)||@within(com.jincou.validation.dynamic.DataSource)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Method realMethod = point.getTarget().getClass().getDeclaredMethod(signature.getName(),
                method.getParameterTypes());
        //此处realMethod是目标对象（原始的）的方法
        DataSource source = method.getAnnotation(DataSource.class);
        logger.info("source值为：{}", JSON.toJSONString(source));
        logger.info("method值为：{}", JSON.toJSONString(method.getName()));
        logger.info("method的注解为：{}", JSON.toJSONString(realMethod.getAnnotations()));
        DataSource ds = realMethod.getAnnotation(DataSource.class);
        logger.info("ds值为：{}", JSON.toJSONString(ds));
        DataSource annotation = AnnotationUtils.findAnnotation(realMethod, DataSource.class);
        logger.info("annotation值为：{}", JSON.toJSONString(annotation));
        // 通过判断 DataSource 中的值来判断当前方法应用哪个数据源
        DynamicDataSource.setDataSource(ds.value());
        System.out.println("当前数据源: " + ds.value());
        logger.info("set datasource is " + ds.value());
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.debug("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
