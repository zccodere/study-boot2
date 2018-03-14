package com.zccoder.boot2.ch3.mvc.entity;

/**
 * <br>
 * 标题: 订单明细<br>
 * 描述: 订单详情<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
public class OrderDetail {

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
