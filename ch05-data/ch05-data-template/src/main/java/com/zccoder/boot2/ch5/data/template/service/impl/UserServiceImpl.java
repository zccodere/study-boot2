package com.zccoder.boot2.ch5.data.template.service.impl;


import com.zccoder.boot2.ch5.data.template.dao.UserDao;
import com.zccoder.boot2.ch5.data.template.entity.User;
import com.zccoder.boot2.ch5.data.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public User geUserById(Long id) {
		User user = userDao.findUserById(id);
		return user;
	}
}
