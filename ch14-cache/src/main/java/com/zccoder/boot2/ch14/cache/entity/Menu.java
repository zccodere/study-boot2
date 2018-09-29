package com.zccoder.boot2.ch14.cache.entity;

import java.io.Serializable;

/**
 * <br>
 * 标题: 菜单实体<br>
 * 描述: 菜单实体<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = 4849834183234502049L;
    private Long id;
    private String code;
    private String name;
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
