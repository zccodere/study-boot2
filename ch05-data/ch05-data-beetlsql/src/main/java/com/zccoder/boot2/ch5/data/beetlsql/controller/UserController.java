package com.zccoder.boot2.ch5.data.beetlsql.controller;


import com.zccoder.boot2.ch5.data.beetlsql.entity.User;
import com.zccoder.boot2.ch5.data.beetlsql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <br>
 * 标题: 用户Controller<br>
 * 描述: 用户Controller<br>
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
    public User say(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/user/query/{name}")
    @ResponseBody
    public List<User> say(@PathVariable String name) {
        return userService.select(name);
    }
}
