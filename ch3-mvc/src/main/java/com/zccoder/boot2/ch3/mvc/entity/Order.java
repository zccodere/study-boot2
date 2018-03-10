package com.zccoder.boot2.ch3.mvc.entity;

/**
 * @author zc
 * @title 订单类
 * @describe 订单信息
 * @date 2018/03/09
 **/
public class Order {

    Long id;

    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
