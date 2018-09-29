package com.zccoder.boot2.ch14.cache.service.impl;

import com.zccoder.boot2.ch14.cache.service.MenuService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zccoder.boot2.ch14.cache.entity.Menu;
import com.zccoder.boot2.ch14.cache.pojo.MenuNode;

/**
 * <br>
 * 标题: 菜单服务实现<br>
 * 描述: 菜单服务实现<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
@Service
public class MenuServiceImpl implements MenuService {

    private Log log = LogFactory.getLog(this.getClass());

    @CacheEvict(cacheNames = {"menu", "menuTree"}, allEntries = true)
    @Override
    public void addMenu(Menu menu) {

    }

    @Cacheable(cacheNames = "menu")
    @Override
    public Menu getMenu(Long id) {
        log.info("call service getMenu " + id);
        // 模拟
        Menu menu = new Menu();
        menu.setCode("test");
        menu.setId(id);
        menu.setName("菜单" + id);
        menu.setParentId(1L);

        return menu;
    }

    @Cacheable("menuTree")
    @Override
    public MenuNode getMenuTree() {

        log.info("call menu tree ");
        Menu root = new Menu();
        root.setCode("root");
        root.setId(1L);
        root.setName("系统管理");
        root.setParentId(null);

        Menu menu = new Menu();
        menu.setCode("menu");
        menu.setId(1L);
        menu.setName("菜单管理");
        menu.setParentId(1L);

        MenuNode tree = new MenuNode();
        tree.setMenu(root);
        tree.setParent(null);

        MenuNode menuTree = new MenuNode();
        menuTree.setMenu(menu);
        menuTree.setParent(tree);
        tree.getChildren().add(menuTree);

        return tree;

    }
}
