package com.zccoder.boot2.ch17.monitor.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import com.zaxxer.hikari.HikariConfigMXBean;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;

/**
 * <br>
 * 标题: 通过访问/application/hikari 获取数据源状态<br>
 * 描述: 通过提交 <pre>
 * curl -H 'Content-Type:application/json' --data '{"max":5}' http://127.0.0.1:8081/application/hikariCP/total
 * </pre>
 * 设置数据源最大连接数<br>
 * 时间: 2018/09/30<br>
 *
 * @author zc
 */
@Endpoint(id = "hikari")
public class HikariCpEndpoint {

    private HikariDataSource dataSource;

    public HikariCpEndpoint(HikariDataSource dataSource) {
        this.dataSource = dataSource;

    }

    @ReadOperation
    public Map<String, Object> info() {
        HashMap<String, Object> map = new HashMap<>(4);
        HikariPoolMXBean mxBean = dataSource.getHikariPoolMXBean();
        HikariConfigMXBean configBean = dataSource.getHikariConfigMXBean();
        map.put("total", configBean.getMaximumPoolSize());
        map.put("active", mxBean.getActiveConnections());
        map.put("idle", mxBean.getIdleConnections());
        map.put("threadWait", mxBean.getThreadsAwaitingConnection());
        return map;
    }

    @WriteOperation
    public void setMax(int max) {
        dataSource.getHikariConfigMXBean().setMaximumPoolSize(max);
    }
}