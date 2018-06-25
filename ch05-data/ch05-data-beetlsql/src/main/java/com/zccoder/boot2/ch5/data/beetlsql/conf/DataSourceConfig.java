package com.zccoder.boot2.ch5.data.beetlsql.conf;

import javax.sql.DataSource;

import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ibeetl.starter.BeetlSqlCustomize;
import com.zaxxer.hikari.HikariDataSource;

/**
 * <br>
 * 标题: 配置数据源<br>
 * 描述: 配置数据源<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
@Configuration
public class DataSourceConfig {
	
	@Bean(name = "dataSource")
	public DataSource datasource(Environment env) {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		ds.setUsername(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		return ds;
	}

	@Bean
	public BeetlSqlDataSource beetlSqlDataSource(Environment env){
		BeetlSqlDataSource source = new BeetlSqlDataSource();
		source.setMasterSource(datasource(env));
		return source;
	}
	
//	@Bean
//	public BeetlSqlCustomize beetlSqlCustomize() {
//		return new BeetlSqlCustomize() {
//			@Override
//			public void customize(SqlManagerFactoryBean sqlManager) {
//				sqlManager.setDbStyle(new MySqlStyle());
//				
//			}
//			
//		};
//	}
}