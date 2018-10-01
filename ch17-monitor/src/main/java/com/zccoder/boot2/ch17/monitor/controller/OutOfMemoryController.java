package com.zccoder.boot2.ch17.monitor.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: 内存溢出 Controller<br>
 * 描述: 内存溢出 Controller<br>
 * 时间: 2018/09/30<br>
 *
 * @author zc
 */
@Controller
public class OutOfMemoryController {

    private Log log = LogFactory.getLog(this.getClass());
    private List<String> list = Collections.synchronizedList(new ArrayList<String>());

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/all.html")
    public @ResponseBody
    String create() {
        addData();
        return "success " + list.size();
    }

    private void addData() {
        log.debug("add data,now is " + list.size());
        int count = 300;
        for (int i = 0; i < count; i++) {
            String s = "abcd" + System.currentTimeMillis();
            list.add(s);
        }

    }

    @RequestMapping("/borrow.html")
    public @ResponseBody
    String borrow() {
        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "ok";
    }


}
