package com.zccoder.boot2.ch10.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.ext.simulate.WebSimulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * 标题: V2 接口<br>
 * 描述: V2 接口<br>
 * 时间: 2018/09/26<br>
 *
 * @author zc
 */
@RestController
@RequestMapping("/api/v2/")
public class OrderApi2Controller {

    @Autowired
    private WebSimulate webSimulate;

    @RequestMapping("/**")
    public void simulateJson(HttpServletRequest request, HttpServletResponse response) {
        webSimulate.execute(request, response);
    }

}
