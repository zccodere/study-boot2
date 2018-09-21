package com.zccoder.boot2.ch8.deploy.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

/**
 * <br>
 * 标题: 数据源配置<br>
 * 描述: 数据源配置<br>
 * 时间: 2018/09/21<br>
 *
 * @author zc
 */
@Configuration
public class DataSourceConf {
    @Bean(name = "dataSource")
    public DataSource devSource(Environment env) {
        HikariDataSource prod = getDataSource(env);
        prod.setMaximumPoolSize(2);
        return prod;

    }

    @Bean(name = "dataSource")
    @Profile("test")
    public DataSource testDatasource(Environment env) {
        HikariDataSource test = getDataSource(env);
        test.setMaximumPoolSize(10);
        return test;
    }

    @Bean(name = "dataSource")
    @Profile("prod")
    public DataSource prodSource(Environment env) {
        HikariDataSource prod = getDataSource(env);

        prod.setMaximumPoolSize(100);
        return prod;

    }

    private HikariDataSource getDataSource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        return ds;
    }
}
