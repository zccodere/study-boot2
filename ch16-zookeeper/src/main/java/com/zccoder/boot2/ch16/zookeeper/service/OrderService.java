package com.zccoder.boot2.ch16.zookeeper.service;

/**
 * <br>
 * 标题: 订单服务<br>
 * 描述: 订单服务<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
public interface OrderService {

    /**
     * 处理订单类型
     *
     * @param type 订单类型
     */
    void makeOrderType(String type);
}
