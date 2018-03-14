package com.zccoder.boot2.ch4.view.beetl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.ext.simulate.WebSimulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <br>
 * 标题: 控制器<br>
 * 描述: 前后端分离，使用 WebSimulate 模拟后端服务<br>
 *
 * @author zc
 * @date 2018/03/14
 */
@Controller
public class SimulateController {

    @Autowired
    private WebSimulate webSimulate;

    @RequestMapping("/api/**")
    public void simluateJson(HttpServletRequest request, HttpServletResponse response) {
        webSimulate.execute(request, response);
    }

    @RequestMapping("/**/*.html")
    public void simluateView(HttpServletRequest request, HttpServletResponse response) {
        webSimulate.execute(request, response);
    }
}