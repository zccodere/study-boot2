package com.zccoder.boot2.ch3.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zccoder.boot2.ch3.mvc.entity.User;
import com.zccoder.boot2.ch3.mvc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @title 用户服务实现
 * @describe 用户服务类
 * //@Transactional 事务配置
 * @author zc
 * @date 2018/03/09
 **/
@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> allUser() {
		return sampleUser(5);
	}
	
	@Override
	public User getUserById(Long id) {
		User user = sampleUser(1).get(0);
		user.setId(id);
		return user;
	}

	private List<User> sampleUser(int num){
		List<User> list = new ArrayList<User>(num);
		for(int i=0;i<num;i++){
			User user = new User();
			user.setId((long)i);
			user.setName("mame"+i);
			list.add(user);
		}
		return list;
	}

	@Override
	public void updateUser(Long id, Integer type) {

	}
}
