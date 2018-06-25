package com.zccoder.boot2.ch5.data.template.controller;

import com.zccoder.boot2.ch5.data.template.entity.User;
import com.zccoder.boot2.ch5.data.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: 用户controller<br>
 * 描述: 用户controller<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/{id}")
	@ResponseBody
	public User say(@PathVariable Long id){
		return userService.geUserById(id);
	}
}
