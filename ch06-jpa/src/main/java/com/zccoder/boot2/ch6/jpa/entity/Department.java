package com.zccoder.boot2.ch6.jpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * <br>
 * 标题: 部门实体<br>
 * 描述: 部门实体<br>
 * 时间: 2018/06/26<br>
 *
 * @author zc
 */
@Entity
public class Department {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 名称
     */
    @Column
    private String name;
    /**
     * 用户信息
     */
    @OneToMany(mappedBy = "department")
    private Set<User> users = new HashSet<>();

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
