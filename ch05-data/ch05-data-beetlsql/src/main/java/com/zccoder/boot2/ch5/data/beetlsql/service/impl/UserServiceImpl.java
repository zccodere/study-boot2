package com.zccoder.boot2.ch5.data.beetlsql.service.impl;


import com.zccoder.boot2.ch5.data.beetlsql.dao.UserDao;
import com.zccoder.boot2.ch5.data.beetlsql.entity.User;
import com.zccoder.boot2.ch5.data.beetlsql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <br>
 * 标题: 用户服务实现<br>
 * 描述: 用户服务实现<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.unique(id);
    }

    @Override
    public List<User> select(String name) {
        User paras = new User();
        paras.setName(name);
        return userDao.selectSample(paras);
    }
}
