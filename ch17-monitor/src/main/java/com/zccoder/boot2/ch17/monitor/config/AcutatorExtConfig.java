package com.zccoder.boot2.ch17.monitor.config;

import javax.sql.DataSource;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;
/**
 * 自定义的监控指标,跟踪http，还有数据源监控
 * @author xiandafu
 *
 */
@Configuration
public class AcutatorExtConfig {
	@ConditionalOnMissingBean(HttpTraceRepository.class)
	@Bean
	public InMemoryHttpTraceRepository traceRepository() {
		InMemoryHttpTraceRepository httpTrace = new  InMemoryHttpTraceRepository();
		httpTrace.setCapacity(2);
		return httpTrace;
	}
	
	
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnEnabledEndpoint
	public HikariCpEndpoint testDataEndpoint(DataSource ds) {
		return new HikariCpEndpoint((HikariDataSource)ds);
	}
	
	
	
}
