package com.zccoder.boot2.ch1.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @title 启动类
* @describe Hello Spring Boot 示例
* @author zc
* @date 2018/03/08
**/
@SpringBootApplication
public class HelloStart {

    public static void main(String[] args) {
        SpringApplication.run(HelloStart.class,args);
    }

}
