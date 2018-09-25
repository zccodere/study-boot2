package com.zccoder.boot2.ch9.test.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.zccoder.boot2.ch9.test.controller.UserController;
import com.zccoder.boot2.ch9.test.entity.User;
import com.zccoder.boot2.ch9.test.service.UserService;

@RunWith(SpringRunner.class)
//需要模拟测试的Controller
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	UserService userService;

	@Test
	public void testMvc() throws Exception {
		int userId = 10;
		int expectedCredit = 100;
		//模拟userService
		given(this.userService.getCredit(anyInt())).willReturn(100);
		//http 调用
		mvc.perform(get("/user/{id}", userId)).andExpect(content().string(String.valueOf(expectedCredit)));
	}
	
	@Test
	public void updateUser() throws Exception {
		int userId = 1;
		String name = "hilijz";
		int expectedCredit = 100;
		given(this.userService.updateUser(any(User.class))).willReturn(true);
		String path = "$.success";
		mvc.perform(get("/user/{id}/{name}", userId,name)).andExpect(jsonPath(path).value(true));
	}
}