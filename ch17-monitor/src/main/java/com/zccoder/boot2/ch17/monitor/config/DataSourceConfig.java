package com.zccoder.boot2.ch17.monitor.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * <br>
 * 标题: 数据源配置<br>
 * 描述: 数据源配置<br>
 * 时间: 2018/09/30<br>
 *
 * @author zc
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    public DataSource datasource(Environment env) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("spring.datasource.url"));
        config.setUsername(env.getProperty("spring.datasource.username"));
        config.setPassword(env.getProperty("spring.datasource.password"));
        config.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        config.setMaximumPoolSize(5);
        return new HikariDataSource(config);
    }
}
