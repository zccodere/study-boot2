package com.zccoder.boot2.ch2.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * <br>
 * 标题: AOP 切面类<br>
 * 描述: 在调用目标方法前后输出日志<br>
 *
 * @author zc
 * @date 2018/03/08
 */
@Configuration
@Aspect
public class AopConfig {

    @Around("@within(org.springframework.stereotype.Controller) ")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        try {
            // 前置通知
            Object[] args = pjp.getArgs();
            System.out.println("args: " + Arrays.asList(args));

            // 调用目标方法
            Object obj = pjp.proceed();

            // 后置通知
            System.out.println("retuen: " + obj);

            return obj;
        } catch (Throwable e) {
            // 异常通知
            throw e;
        }
    }
}
