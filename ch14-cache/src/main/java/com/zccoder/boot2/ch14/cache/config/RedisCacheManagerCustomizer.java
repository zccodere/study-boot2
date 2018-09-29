package com.zccoder.boot2.ch14.cache.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

/**
 * <br>
 * 标题: 配置缓存<br>
 * 描述: 配置缓存<br>
 * // @Configuration
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
public class RedisCacheManagerCustomizer {

    /**
     * 自定义缓存配置
     * // @Bean
     *
     * @param connectionFactory Redis Connection
     * @return RedisCacheManager
     */
    public RedisCacheManager getRedisCacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheWriter cacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer(loader);
        SerializationPair<Object> pair = SerializationPair.fromSerializer(jdkSerializer);

        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        //设置所有的超时时间
        cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(3600));

        //设置单个缓存的超时时间
        Map<String, RedisCacheConfiguration> initialCacheConfigurations = new HashMap<>(4);
        initialCacheConfigurations.put("user", cacheConfig.entryTtl(Duration.ofSeconds(60)));

        return new RedisCacheManager(cacheWriter, cacheConfig, initialCacheConfigurations);
    }
}
