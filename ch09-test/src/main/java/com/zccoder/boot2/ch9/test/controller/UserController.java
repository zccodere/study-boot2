package com.zccoder.boot2.ch9.test.controller;

import com.zccoder.boot2.ch9.test.entity.User;
import com.zccoder.boot2.ch9.test.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: 用户 Controller<br>
 * 描述: 用户 Controller<br>
 * 时间: 2018/09/25<br>
 *
 * @author zc
 */
@Controller
public class UserController {
    private Log log = LogFactory.getLog(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/user/{id}")
    public @ResponseBody
    String getUser(@PathVariable Integer id) {
        return String.valueOf(userService.getCredit(id));
    }

    @RequestMapping("/user/{id}/{name}")
    public @ResponseBody
    String updateUser(@PathVariable Integer id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        userService.updateUser(user);
        return "{\"success\":true}";
    }


}
