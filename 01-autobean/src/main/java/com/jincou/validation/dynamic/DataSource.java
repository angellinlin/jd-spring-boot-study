package com.jincou.validation.dynamic;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @author zhouguilong6
 * @date 2024/12/25 15:48
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value() default DataSourceNames.FIRST;
}