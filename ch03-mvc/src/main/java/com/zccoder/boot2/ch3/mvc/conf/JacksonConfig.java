package com.zccoder.boot2.ch3.mvc.conf;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <br>
 * 标题: Jackson配置<br>
 * 描述: 默认使用Jackson实现JSON的序列化和反序列化<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }
}
