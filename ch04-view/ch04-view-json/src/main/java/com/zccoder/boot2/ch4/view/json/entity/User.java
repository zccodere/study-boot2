package com.zccoder.boot2.ch4.view.json.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * <br>
 * 标题: POJO类<br>
 * 描述: 用户实体<br>
 *
 * @author zc
 * @date 2018/03/14
 */
public class User {

    public interface IdView {
    };

    public interface IdNameView extends IdView {
    };

    @JsonView(IdView.class)
    private Integer id;
    @JsonView(IdNameView.class)
    private String name;
    @JsonIgnore
    BigDecimal salary;

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
