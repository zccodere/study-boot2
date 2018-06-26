package com.zccoder.boot2.ch6.jpa.controller;

import java.util.List;

import com.zccoder.boot2.ch6.jpa.entity.User;
import com.zccoder.boot2.ch6.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <br>
 * 标题: 用户Controller<br>
 * 描述: 用户Controller<br>
 * 时间: 2018/06/26<br>
 *
 * @author zc
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/finduser")
    @ResponseBody
    public String findUser(int userId) {
        User user = userService.findUser(userId);
        return user.getName();
    }

    @RequestMapping("/adduser")
    @ResponseBody
    public String addUser(User user) {
        int id = userService.addUser(user);
        return String.valueOf(id);
    }

    @RequestMapping("/alluser")
    @ResponseBody
    public String alluser(int page, int size) {
        List<User> list = userService.getAllUser(page, size);
        return String.valueOf(list.size());
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public String getUser(String name) {
        User user = userService.getUser(name);
        return String.valueOf(user.getName());
    }

    @RequestMapping("/getdepartuser")
    @ResponseBody
    public String getDepartmentUser(String name, Integer deptId) {
        User user = userService.getUser(name, deptId);
        return user == null ? "" : String.valueOf(user.getName());
    }

    @RequestMapping("/pagequery")
    @ResponseBody
    public String pageQuery(Integer deptId, int page, int size) {
        Page<User> users = userService.queryUser2(deptId, PageRequest.of(page,size));
        return String.valueOf(users.getTotalElements());
    }

    @RequestMapping("/example")
    @ResponseBody
    public String example(String name) {
        List<User> users = userService.getByExample(name);
        return String.valueOf(users.size());
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        userService.updateUser();
        return "success";
    }
}
