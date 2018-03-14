package com.zccoder.boot2.ch3.mvc.controller;

import java.util.List;

import com.zccoder.boot2.ch3.mvc.entity.User;
import com.zccoder.boot2.ch3.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: URL映射<br>
 * 描述: mvc url映射测试<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
@Controller
@RequestMapping("/urlmapper")
public class UrlMapperController {

    @Autowired
    UserService userService;


    @RequestMapping(path = "/user/all/*.json", method = RequestMethod.GET)
    @ResponseBody
    public List<User> allUser() {
        return userService.allUser();
    }


    @RequestMapping(path = "/user/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "/{userId}.json", produces = "application/json")
    @ResponseBody
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(value = "/consumes/test.json", consumes = "application/json")
    @ResponseBody
    public User forJson() {
        return userService.getUserById(1L);
    }

}
