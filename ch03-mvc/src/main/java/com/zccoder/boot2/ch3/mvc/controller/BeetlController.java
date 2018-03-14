package com.zccoder.boot2.ch3.mvc.controller;

import com.zccoder.boot2.ch3.mvc.entity.User;
import com.zccoder.boot2.ch3.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <br>
 * 标题: Beetl模版引擎<br>
 * 描述: 测试使用模板引擎Beetl<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
@Controller
@RequestMapping("/beetl")
public class BeetlController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index.html")
    public String say(Model model) {
        model.addAttribute("name", "hello,world");
        return "/index.btl";
    }

    @GetMapping("/showuser.html")
    public ModelAndView showUserInfo(Long id) {
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(id);
        view.addObject("user", user);
        view.setViewName("/userInfo.btl");
        return view;
    }


}
