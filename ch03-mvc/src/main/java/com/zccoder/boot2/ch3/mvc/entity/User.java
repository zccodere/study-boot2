package com.zccoder.boot2.ch3.mvc.entity;

/**
 * <br>
 * 标题: 用户类<br>
 * 描述: 用户信息<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
public class User {

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
