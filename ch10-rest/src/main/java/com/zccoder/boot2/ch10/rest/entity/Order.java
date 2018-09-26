package com.zccoder.boot2.ch10.rest.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * 标题: 订单实体<br>
 * 描述: 订单实体<br>
 * 时间: 2018/09/26<br>
 *
 * @author zc
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 687873238202700359L;
    private String id;
    private String name;
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
