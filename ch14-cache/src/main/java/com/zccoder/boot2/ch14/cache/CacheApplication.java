package com.zccoder.boot2.ch14.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: 启用缓存功能<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
@SpringBootApplication
@EnableCaching
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }
}
