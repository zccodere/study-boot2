package com.zccoder.boot2.ch3.mvc.controller.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <br>
 * 标题: 进行验证<br>
 * 描述: 实现 ConstraintValidator 接口<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime, Integer> {

    WorkOverTime work;

    int max;

    @Override
    public void initialize(WorkOverTime work) {
        // 获取注解的定义
        this.work = work;
        max = work.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 校验逻辑
        if (value == null) {
            return true;
        }
        return value < max;
    }
}
