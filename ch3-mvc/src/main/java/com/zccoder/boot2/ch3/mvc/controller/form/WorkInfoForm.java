package com.zccoder.boot2.ch3.mvc.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.zccoder.boot2.ch3.mvc.controller.validate.WorkOverTime;

/**
 * @author zc
 * @title JSR303
 * @describe 包含了验证注解的JavaBean
 * @date 2018/03/09
 **/
public class WorkInfoForm {

    /**
     * 定义一个类，更新时校验组
     */
    public interface Update {
    }

    /**
     * 定义一个类，添加时校验组
     */
    public interface Add {
    }

    @NotNull(groups = {Update.class})
    @Null(groups = {Update.class})
    Long id;
    @Size(min = 3, max = 20)
    String name;
    @Email
    String email;
    @WorkOverTime(max = 5)
    Integer workTime;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }


}
