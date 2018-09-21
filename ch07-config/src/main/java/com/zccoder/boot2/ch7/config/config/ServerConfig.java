package com.zccoder.boot2.ch7.config.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <br>
 * 标题: 使用 @ConfigurationProperties 加载配置参数<br>
 * 描述: 使用 @ConfigurationProperties 加载配置参数<br>
 * 时间: 2018/09/21<br>
 *
 * @author zc
 */
@ConfigurationProperties("server")
@Configuration
public class ServerConfig {

    private int port;

    private Servlet servlet = new Servlet();

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    public Servlet getServlet() {
        return servlet;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }


    public static class Servlet {
        String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

    }
}
