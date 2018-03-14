package com.zccoder.boot2.ch4.view.json.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: 控制器<br>
 * 描述: 直接返回字符串<br>
 *
 * @author zc
 * @date 2018/03/14
 */
@Controller
public class TreeModelController {
    @RequestMapping("/sayhello.html")
    @ResponseBody
    public String say() {
        return "hello world";
    }
}
