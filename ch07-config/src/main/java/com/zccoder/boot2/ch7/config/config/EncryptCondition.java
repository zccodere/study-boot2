package com.zccoder.boot2.ch7.config.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * <br>
 * 标题: 加密条件<br>
 * 描述: 加密条件<br>
 * 时间: 2018/09/21<br>
 *
 * @author zc
 */
public class EncryptCondition implements Condition {

    @Override
    public boolean matches(ConditionContext ctx, AnnotatedTypeMetadata metadata) {
        Resource res = ctx.getResourceLoader().getResource("encrypt.txt");
        Environment env = ctx.getEnvironment();
        // 当 存在encrypt.txt文件 且 mobile.encrypt.enable为true 时，才匹配成功
        return res.exists() && env.containsProperty("mobile.encrypt.enable");
    }

}