package com.zccoder.boot2.ch3.mvc.controller.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author zc
 * @title 自定义校验注解
 * @describe 加班时间校验
 * @date 2018/03/09
 **/
@Constraint(validatedBy = {WorkOverTimeValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkOverTime {

    /**
     * 用于创建错误信息
     * */
    String message() default "加班时间过长,不能超过{max}";

    /**
     * 加班时间
     * @return
     */
    int max() default 4;

    /**
     * 验证规则分组
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * 验证的有效负荷
     * @return
     */
    Class<? extends Payload>[] payload() default {};
}