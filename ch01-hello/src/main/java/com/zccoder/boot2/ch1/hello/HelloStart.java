package com.zccoder.boot2.ch1.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: Hello Spring Boot 示例<br>
 *
 * @author zc
 * @date 2018/03/08
 */
@SpringBootApplication
public class HelloStart {

    public static void main(String[] args) {
        SpringApplication.run(HelloStart.class, args);
    }

}
