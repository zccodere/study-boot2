package com.zccoder.boot2.ch3.mvc.controller.form;

import com.zccoder.boot2.ch3.mvc.entity.Order;
import com.zccoder.boot2.ch3.mvc.entity.OrderDetail;

import java.util.List;

/**
 * @author zc
 * @title 订单信息类
 * @describe 用户提交订单信息，包含多个订单明细
 * @date 2018/03/09
 **/
public class OrderPostForm {

    /**
     * 订单
     */
    public Order order;

    /**
     * 订单明细
     */
    public List<OrderDetail> details;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }


}
