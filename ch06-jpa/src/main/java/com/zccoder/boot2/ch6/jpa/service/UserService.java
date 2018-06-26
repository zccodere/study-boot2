package com.zccoder.boot2.ch6.jpa.service;

import java.util.List;

import com.zccoder.boot2.ch6.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <br>
 * 标题: 用户服务<br>
 * 描述: 用户服务<br>
 * 时间: 2018/06/26<br>
 *
 * @author zc
 */
public interface UserService {
    /**
     * 查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    User findUser(Integer id);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 影响行数
     */
    Integer addUser(User user);

    /**
     * 分页查询
     *
     * @param start 开始
     * @param end   结束
     * @return 用户集合
     */
    List<User> getAllUser(int start, int end);

    /**
     * 查询用户
     *
     * @param name 名称
     * @return 用户信息
     */
    User getUser(String name);

    /**
     * 查询用户
     *
     * @param name         名称
     * @param departmentId 部门ID
     * @return 用户信息
     */
    User getUser(String name, Integer departmentId);

    /**
     * 分页查询用户
     *
     * @param departmentId 部门ID
     * @param page         分页参数
     * @return 用户集合
     */
    Page<User> queryUser(Integer departmentId, Pageable page);

    /**
     * 分页查询用户
     *
     * @param departmentId 部门ID
     * @param page         分页参数
     * @return 用户集合
     */
    Page<User> queryUser2(Integer departmentId, Pageable page);

    /**
     * 查询用户
     *
     * @param name 名称
     * @return 用户集合
     */
    List<User> getByExample(String name);

    /**
     * 修改用户
     */
    void updateUser();
}
