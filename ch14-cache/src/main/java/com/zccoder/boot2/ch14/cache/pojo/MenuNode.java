package com.zccoder.boot2.ch14.cache.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zccoder.boot2.ch14.cache.entity.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <br>
 * 标题: 菜单节点实体<br>
 * 描述: 菜单节点实体<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
public class MenuNode implements Serializable {

    private static final long serialVersionUID = 2474613267174275534L;

    private Menu menu;
    private List<MenuNode> children = new ArrayList<MenuNode>();
    @JsonIgnore
    private MenuNode parent;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<MenuNode> getChildren() {
        return children;
    }

    public void setChildren(List<MenuNode> children) {
        this.children = children;
    }

    public MenuNode getParent() {
        return parent;
    }

    public void setParent(MenuNode parent) {
        this.parent = parent;
    }

}
