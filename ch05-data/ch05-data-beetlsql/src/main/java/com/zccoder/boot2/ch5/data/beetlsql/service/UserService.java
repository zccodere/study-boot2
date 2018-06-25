package com.zccoder.boot2.ch5.data.beetlsql.service;

import com.zccoder.boot2.ch5.data.beetlsql.entity.User;

import java.util.List;

/**
 * <br>
 * 标题: 用户服务<br>
 * 描述: 用户服务<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
public interface UserService {
    /**
     * 根据用户ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    User getUserById(Integer id);

    /**
     * 根据用户名称查询用户列表
     *
     * @param name 名称
     * @return 用户列表
     */
    List<User> select(String name);

}
