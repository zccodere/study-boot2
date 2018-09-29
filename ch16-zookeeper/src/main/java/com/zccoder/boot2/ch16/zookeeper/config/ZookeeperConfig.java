package com.zccoder.boot2.ch16.zookeeper.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceInstanceBuilder;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br>
 * 标题: Zookeeper 配置<br>
 * 描述: Zookeeper 配置<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
@Configuration
public class ZookeeperConfig {

    @Value("${zk.url}")
    private String zkUrl;

    private Log log = LogFactory.getLog(ZookeeperConfig.class);

    @Bean
    public CuratorFramework getCuratorFramework() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkUrl, retryPolicy);
        client.getCuratorListenable().addListener(new CuratorListener() {
            @Override
            public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                CuratorEventType type = event.getType();
                if (type == CuratorEventType.WATCHED) {
                    WatchedEvent we = event.getWatchedEvent();
                    EventType et = we.getType();
                    if (we.getPath() != null) {
                        log.info(et + ":" + we.getPath());
                        client.checkExists().watched().forPath(we.getPath());
                    }

                }
            }

        });

        client.start();

        registerService(client);
        ServiceInstance<Map> service = findService(client, "book");
        return client;

    }

    protected void registerService(CuratorFramework client) throws Exception {

        // 构造一个服务描述
        ServiceInstanceBuilder<Map> service = ServiceInstance.builder();
        service.address("192.168.1.100");
        service.port(8080);
        service.name("book");
        Map config = new HashMap(4);
        config.put("url", "/api/v3/book");
        service.payload(config);

        ServiceInstance<Map> instance = service.build();

        ServiceDiscovery<Map> serviceDiscovery = ServiceDiscoveryBuilder.builder(Map.class).client(client)
                .serializer(new JsonInstanceSerializer<Map>(Map.class)).basePath("/service").build();
        // 服务注册
        serviceDiscovery.registerService(instance);

        serviceDiscovery.start();

    }

    protected ServiceInstance<Map> findService(CuratorFramework client, String serviceName) throws Exception {

        ServiceDiscovery<Map> serviceDiscovery = ServiceDiscoveryBuilder.builder(Map.class).client(client)
                .serializer(new JsonInstanceSerializer<Map>(Map.class)).basePath("/service").build();

        serviceDiscovery.start();

        Collection<ServiceInstance<Map>> all = serviceDiscovery.queryForInstances(serviceName);
        if (all.size() == 0) {
            return null;
        } else {
            // 取第一个服务
            ServiceInstance<Map> service = new ArrayList<ServiceInstance<Map>>(all).get(0);
            System.out.println(service.getAddress());
            System.out.println(service.getPayload());
            return service;
        }
    }
}
