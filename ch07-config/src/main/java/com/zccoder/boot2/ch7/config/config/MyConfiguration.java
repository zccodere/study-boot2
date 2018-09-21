package com.zccoder.boot2.ch7.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br>
 * 标题: 自定义配置<br>
 * 描述: 自定义配置<br>
 * 时间: 2018/09/21<br>
 *
 * @author zc
 */
@Configuration
public class MyConfiguration {

    @Bean
    public UrlTestBean getURLTestBean() {
        return new UrlTestBean();
    }
}
