package com.zccoder.boot2.ch17.monitor.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 标题: 消息创建 健康检查<br>
 * 描述: 消息创建 健康检查<br>
 * 时间: 2018/09/30<br>
 *
 * @author zc
 */
@Component
public class MessageCenterHealthIndicator implements HealthIndicator {

    public MessageCenterHealthIndicator() {
    }

    @Override
    public Health health() {

        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Message", "error " + errorCode).build();
        }
        return Health.up().build();
    }

    protected int check() {
        // 模拟返回一个错误状态
        return 1;
    }
}
