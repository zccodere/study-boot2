package com.zccoder.boot2.ch1.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @title Hello控制器
* @describe 简单演示
* @author zc
* @date 2018/03/08
**/
@Controller
public class HelloController {

    @RequestMapping("/say.html")
    @ResponseBody
    public String say(){
        return "Hello Spring Boot";
    }
}
