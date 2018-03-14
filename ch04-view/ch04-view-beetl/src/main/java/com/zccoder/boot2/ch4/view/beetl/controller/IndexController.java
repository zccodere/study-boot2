package com.zccoder.boot2.ch4.view.beetl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <br>
 * 标题: 控制器<br>
 * 描述: 配置视图跳转<br>
 * 学习beetl语法，可以参考在线体验:http://ibeetl.com/beetlonline/,学习大部分语法
 *
 * @author zc
 * @date 2018/03/14
 */
@Controller
public class IndexController {

    @RequestMapping("/index.do")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/index.btl");
        view.addObject("name", "lijz");
        return view;
    }

    @RequestMapping("/test.do")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView("/test.html");
        return view;
    }
}
