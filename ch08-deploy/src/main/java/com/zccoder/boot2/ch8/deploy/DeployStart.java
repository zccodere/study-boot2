package com.zccoder.boot2.ch8.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: 启动类<br>
 * 时间: 2018/09/21<br>
 *
 * @author zc
 */
@SpringBootApplication
public class DeployStart extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DeployStart.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DeployStart.class, args);
    }

}
