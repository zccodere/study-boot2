package com.zccoder.boot2.ch14.cache.controller;

import com.zccoder.boot2.ch14.cache.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zccoder.boot2.ch14.cache.entity.Menu;
import com.zccoder.boot2.ch14.cache.pojo.MenuNode;

/**
 * <br>
 * 标题: 管理员 Controller<br>
 * 描述: 管理员 Controller<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
@Controller
public class AdminController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/addmenu.json")
    public @ResponseBody
    String add() throws Exception {
        menuService.addMenu(null);
        //模拟改变缓存
        return "{\"success\":true}";
    }

    @RequestMapping("/getmenu.json")
    public @ResponseBody
    Menu getMenu(Long menuId) throws Exception {
        return menuService.getMenu(menuId);
    }

    @RequestMapping("/tree.json")
    public @ResponseBody
    MenuNode tree() throws Exception {
        return menuService.getMenuTree();
    }


}
