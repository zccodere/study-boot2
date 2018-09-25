package com.zccoder.boot2.ch9.test.db;

import static org.junit.Assert.*;

import com.zccoder.boot2.ch9.test.dao.UserDao;
import com.zccoder.boot2.ch9.test.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zccoder.boot2.ch9.test.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional 
public class UserDbTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
    UserDao userDao;
	
	@Test
	@Sql({"classpath:com/zccoder/boot2/ch9/test/db/user.sql"}) //初始化一条主键为1的用户数据
	public void upateNameTest(){
		 
		 User user = new User();
		 user.setId(1);
		 user.setName("hello123");
		 boolean success = userService.updateUser(user);
		 User dbUser = userDao.unique(1);
		 assertEquals(dbUser.getName(),"hello123");
		 	 
	}
	
	
}
