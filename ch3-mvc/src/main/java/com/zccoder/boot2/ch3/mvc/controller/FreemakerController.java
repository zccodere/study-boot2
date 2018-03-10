package com.zccoder.boot2.ch3.mvc.controller;

import com.zccoder.boot2.ch3.mvc.entity.User;
import com.zccoder.boot2.ch3.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zc
 * @title Freemaker控制器
 * @describe 使用Freemaker
 * @date 2018/03/09
 **/
@Controller
@RequestMapping("/freemarker")
public class FreemakerController {

    @Autowired
    private UserService userService;

    /***
     * http://127.0.0.1:8080/freemarker//showuser.html?id=1
     * @param id
     * @return
     */
    @GetMapping("/showuser.html")
    public ModelAndView showUserInfo(Long id) {
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(id);
        view.addObject("user", user);
        view.setViewName("/userInfo");
        return view;
    }

}
