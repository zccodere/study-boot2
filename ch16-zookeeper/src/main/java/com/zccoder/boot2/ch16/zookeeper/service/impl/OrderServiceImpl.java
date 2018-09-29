package com.zccoder.boot2.ch16.zookeeper.service.impl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zccoder.boot2.ch16.zookeeper.service.OrderService;

/**
 * <br>
 * 标题: 订单服务实现<br>
 * 描述: 订单服务实现<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
@Service
public class OrderServiceImpl implements OrderService {
    private Log log = LogFactory.getLog(OrderServiceImpl.class);

    @Autowired
    private CuratorFramework zkClient;

    private static final String LOCK_PATH = "/lock/order";

    @Override
    public void makeOrderType(String type) {
        String path = LOCK_PATH + "/" + type;
        log.info("try do job for " + type);
        try {
            InterProcessMutex lock = new InterProcessMutex(zkClient, path);
            int time = 10;
            if (lock.acquire(time, TimeUnit.HOURS)) {
                try {

                    //模拟用时5秒
                    Thread.sleep(1000 * 5);
                    log.info("do job " + type + " done");
                } finally {
                    lock.release();
                }

            }
        } catch (Exception ex) {
            //zk异常
            ex.printStackTrace();
        }
    }
}
