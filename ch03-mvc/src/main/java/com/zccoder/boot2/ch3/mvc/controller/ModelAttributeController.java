package com.zccoder.boot2.ch3.mvc.controller;

import com.zccoder.boot2.ch3.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: // @ModelAttribute 注解<br>
 * 描述: 调用方法前会先调用此注解修饰的方法<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
@Controller
@RequestMapping("/modelattribute")
public class ModelAttributeController {

    @Autowired
    private UserService userService;

    /**
     * Controller方法中的公共方法，调用方法前先调用此方法。
     *
     * @param id
     * @param model
     */
    @ModelAttribute
    public void findUserById(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
    }

    @GetMapping(path = "/{id}/get.json")
    @ResponseBody
    public String getUser(Model model) {
        System.out.println(model.containsAttribute("user"));
        return "success";
    }


}
