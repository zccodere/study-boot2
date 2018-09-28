package com.zccoder.boot2.ch12.redis.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: Redis Controller<br>
 * 描述: Redis Controller<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
@Controller
@RequestMapping("/redis")
public class RedisTemplateController {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisClient;

    @RequestMapping("/simpleset.html")
    public @ResponseBody
    String simpleSet() {
        redisClient.opsForValue().set("key-0", "hello");
        redisClient.opsForValue().set("key-1", User.getSampleUser());
        return "success";
    }

    @RequestMapping("/simpleget.html")
    public @ResponseBody
    String simpleGet() {
        String value = (String) redisClient.opsForValue().get("key-0");
        User uer = (User) redisClient.opsForValue().get("key-1");
        return "success";

    }

    public static class User implements java.io.Serializable {
        int id;
        String name;
        Date date = new Date();

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public static User getSampleUser() {
            User user = new User();
            user.setId(123);
            user.setName("abc");
            return user;
        }

    }


}
