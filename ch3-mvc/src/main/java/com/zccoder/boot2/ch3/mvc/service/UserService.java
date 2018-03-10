package com.zccoder.boot2.ch3.mvc.service;

import com.zccoder.boot2.ch3.mvc.entity.User;

import java.util.List;

/**
 * @title 用户服务
 * @describe 用户服务类
 * @author zc
 * @date 2018/03/09
 **/
public interface UserService {

    /**
     * 获取所有用户
     * @return
     */
    List<User> allUser();

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 更新用户状态
     * @param id
     * @param type
     */
    void updateUser(Long id, Integer type);
}
