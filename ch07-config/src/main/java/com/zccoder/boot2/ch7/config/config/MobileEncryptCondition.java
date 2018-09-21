package com.zccoder.boot2.ch7.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * <br>
 * 标题: 手机加密条件配置<br>
 * 描述: 手机加密条件配置<br>
 * 时间: 2018/09/21<br>
 *
 * @author zc
 */
@Configuration
@Conditional(EncryptCondition.class)
public class MobileEncryptCondition {

    @Bean
    public MobileEncryptBean mobileEncryptBean() {
        return new MobileEncryptBean();
    }

}
