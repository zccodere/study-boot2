package com.zccoder.boot2.ch14.cache.service;

import com.zccoder.boot2.ch14.cache.entity.Menu;
import com.zccoder.boot2.ch14.cache.pojo.MenuNode;

/**
 * <br>
 * 标题: 菜单服务<br>
 * 描述: 菜单服务<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
public interface MenuService {
    /**
     * 增加菜单
     *
     * @param menu 菜单
     */
    void addMenu(Menu menu);

    /**
     * 获取菜单
     *
     * @param id ID
     * @return 菜单
     */
    Menu getMenu(Long id);

    /**
     * 获取菜单节点
     *
     * @return 菜单节点
     */
    MenuNode getMenuTree();
}
