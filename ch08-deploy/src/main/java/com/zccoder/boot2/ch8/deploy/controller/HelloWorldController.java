package com.zccoder.boot2.ch8.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: Controller<br>
 * 描述: Controller<br>
 * 时间: 2018/09/21<br>
 *
 * @author zc
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/sayhello.html")
    public @ResponseBody
    String say() {
        return "hello world";
    }

}
