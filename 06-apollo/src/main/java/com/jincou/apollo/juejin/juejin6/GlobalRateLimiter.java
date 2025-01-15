package com.jincou.apollo.juejin.juejin6;

/**
 * @author zhouguilong6
 * @date 2025/1/15 15:50
 */
import org.redisson.api.RateIntervalUnit;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalRateLimiter {

    String key();

    long rate();

    long rateInterval() default 1L;

    RateIntervalUnit rateIntervalUnit() default RateIntervalUnit.SECONDS;

}

