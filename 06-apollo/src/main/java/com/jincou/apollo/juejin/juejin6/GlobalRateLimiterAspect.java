//package com.jincou.apollo.juejin.juejin6;
//
///**
// * @author zhouguilong6
// * @date 2025/1/15 15:17
// */
//
//import lombok.extern.slf4j.Slf4j;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.redisson.Redisson;
//import org.redisson.api.RRateLimiter;
//import org.redisson.api.RateIntervalUnit;
//import org.redisson.api.RateType;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.DefaultParameterNameDiscoverer;
//import org.springframework.expression.Expression;
//import org.springframework.expression.ExpressionParser;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//import org.springframework.expression.spel.support.StandardEvaluationContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.lang.reflect.Method;
//import java.util.concurrent.TimeUnit;
//
//@Aspect
//@Component
//@Slf4j
//public class GlobalRateLimiterAspect {
//
//    @Resource
//    private Redisson redisson;
//    @Value("${spring.application.name}")
//    private String applicationName;
//    private final DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
//
//    @Pointcut(value = "@annotation(com.jincou.apollo.juejin.juejin6.GlobalRateLimiter)")
//    public void cut() {
//    }
//
//    @Around(value = "cut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        String className = method.getDeclaringClass().getName();
//        String methodName = method.getName();
//        GlobalRateLimiter globalRateLimiter = method.getDeclaredAnnotation(GlobalRateLimiter.class);
//        Object[] params = joinPoint.getArgs();
//        long rate = globalRateLimiter.rate();
//        String key = globalRateLimiter.key();
//        long rateInterval = globalRateLimiter.rateInterval();
//        RateIntervalUnit rateIntervalUnit = globalRateLimiter.rateIntervalUnit();
//        if (key.contains("#")) {
//            ExpressionParser parser = new SpelExpressionParser();
//            StandardEvaluationContext ctx = new StandardEvaluationContext();
//            String[] parameterNames = discoverer.getParameterNames(method);
//            if (parameterNames != null) {
//                for (int i = 0; i < parameterNames.length; i++) {
//                    ctx.setVariable(parameterNames[i], params[i]);
//                }
//            }
//            Expression expression = parser.parseExpression(key);
//            Object value = expression.getValue(ctx);
//            if (value == null) {
//                throw new RuntimeException("key无效");
//            }
//            key = value.toString();
//        }
//        key = applicationName + "_" + className + "_" + methodName + "_" + key;
//        log.info("设置限流锁key={}", key);
//        RRateLimiter rateLimiter = this.redisson.getRateLimiter(key);
//        if (!rateLimiter.isExists()) {
//            log.info("设置流量,rate={},rateInterval={},rateIntervalUnit={}", rate, rateInterval, rateIntervalUnit);
//            rateLimiter.trySetRate(RateType.OVERALL, rate, rateInterval, rateIntervalUnit);
//            //设置一个过期时间，避免key一直存在浪费内存，这里设置为延长5分钟
//            long millis = rateIntervalUnit.toMillis(rateInterval);
//            this.redisson.getBucket(key).expire(Long.sum(5 * 1000 * 60, millis), TimeUnit.MILLISECONDS);
//        }
//        boolean acquire = rateLimiter.tryAcquire(1);
//        if (!acquire) {
//            //这里直接抛出了异常  也可以抛出自定义异常，通过全局异常处理器拦截进行一些其他逻辑的处理
//            throw new RuntimeException("请求频率过高，此操作已被限制");
//        }
//        return joinPoint.proceed();
//    }
//}
