package com.zccoder.boot2.ch16.zookeeper.controller;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zccoder.boot2.ch16.zookeeper.service.OrderService;

/**
 * <br>
 * 标题: Controller<br>
 * 描述: Controller<br>
 * 时间: 2018/09/29<br>
 *
 * @author zc
 */
@Controller
public class ZookeeperTestController {

    @Autowired
    private CuratorFramework zkClient;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/create.html")
    public @ResponseBody
    String create(String path) throws Exception {
        zkClient.create().forPath(path, new byte[0]);
        return "create " + path;
    }

    @RequestMapping("/delete.html")
    public @ResponseBody
    String delete(String path) throws Exception {
        zkClient.delete().forPath(path);
        return "success delete " + path;
    }

    @RequestMapping("/getdata.html")
    public @ResponseBody
    String getData(String path) throws Exception {
        byte[] bs = zkClient.getData().forPath(path);
        String ret = new String(bs);
        return "get data " + ret;
    }

    @RequestMapping("/setdata.html")
    public @ResponseBody
    String setData(String path, String data) throws Exception {
        zkClient.setData().forPath(path, data.getBytes());
        return "set data " + data;
    }

    @RequestMapping("/check.html")
    public @ResponseBody
    String check(String path) throws Exception {
        Stat stat = zkClient.checkExists().forPath(path);
        return "stat " + stat;
    }

    @RequestMapping("/children.html")
    public @ResponseBody
    String children(String path) throws Exception {
        List<String> children = zkClient.getChildren().forPath(path);
        return "children " + children;
    }

    @RequestMapping("/watch.html")
    public @ResponseBody
    String watch(String path) throws Exception {
        Stat stat = zkClient.checkExists().watched().forPath(path);
        return "watch " + path;
    }

    @RequestMapping("/makeorder.html")
    public @ResponseBody
    String makeOrder() throws Exception {
        orderService.makeOrderType("book");
        return "success";
    }


}
