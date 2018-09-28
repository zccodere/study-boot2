package com.zccoder.boot2.ch12.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
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
@RequestMapping("/rediskey") 
public class StrKeyRedisTemplateController {

	@Autowired
	@Qualifier("strKeyRedisTemplate")
	private RedisTemplate redisClient;

	@RequestMapping("/simpleset.html") 
	public @ResponseBody String simpleSet(){
		redisClient.opsForValue().set("key-0","hello");
		return "success";
	} 
	
	@RequestMapping("/simpleget.html") 
	public @ResponseBody String simpleGet(){
		String value = (String)redisClient.opsForValue().get("key-0");
		return "success";
		
	} 
	
}
