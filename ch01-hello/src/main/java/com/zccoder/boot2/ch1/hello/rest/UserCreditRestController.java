package com.zccoder.boot2.ch1.hello.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * 标题: RESTFul服务<br>
 * 描述: 用户信用等级服务<br>
 *
 * @author zc
 * @date 2018/03/08
 **/
@RestController
public class UserCreditRestController {

    private static final int TEST_NUM = 3;

    @RequestMapping("/usercredit/{id}")
    public Integer getCreditLevel(@PathVariable Integer id) {
        // 模拟id用户的信用等级
        return id + TEST_NUM;
    }
}
