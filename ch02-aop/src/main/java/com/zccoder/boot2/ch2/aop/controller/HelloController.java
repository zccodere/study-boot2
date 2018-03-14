package com.zccoder.boot2.ch2.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: Hello控制器<br>
 * 描述: 简单演示<br>
 *
 * @author zc
 * @date 2018/03/08
 **/
@Controller
public class HelloController {

    @RequestMapping("/say.html")
    @ResponseBody
    public String say(String name) {
        return "Hello Spring Boot";
    }
}
