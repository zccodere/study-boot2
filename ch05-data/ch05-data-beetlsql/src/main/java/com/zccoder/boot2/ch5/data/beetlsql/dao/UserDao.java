package com.zccoder.boot2.ch5.data.beetlsql.dao;


import com.zccoder.boot2.ch5.data.beetlsql.entity.User;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * <br>
 * 标题: 用户 DAO<br>
 * 描述: 用户 DAO<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
@SqlResource("user")
public interface UserDao extends BaseMapper<User> {

    /**
     * 根据用户名查询用户
     * @param user 用户名
     * @return 用户列表
     */
    List<User> selectSample(User user);
}