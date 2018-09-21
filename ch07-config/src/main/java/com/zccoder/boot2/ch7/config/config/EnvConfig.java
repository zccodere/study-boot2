package com.zccoder.boot2.ch7.config.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * <br>
 * 标题: 条件注解<br>
 * 描述: 条件注解<br>
 * 时间: 2018/09/21<br>
 *
 * @author zc
 */
@Configuration
@ConditionalOnJava(range = Range.EQUAL_OR_NEWER, value = JavaVersion.EIGHT)
public class EnvConfig implements BeanPostProcessor {

    @Autowired
    private Environment env;

    public int getServerPort() {
        return env.getProperty("server.port", Integer.class);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UrlTestBean) {
            System.out.println("=========== " + beanName);
        }
        return bean;
    }
}
