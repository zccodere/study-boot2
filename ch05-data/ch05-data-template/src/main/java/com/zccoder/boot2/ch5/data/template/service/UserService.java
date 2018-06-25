package com.zccoder.boot2.ch5.data.template.service;

import com.zccoder.boot2.ch5.data.template.entity.User;

/**
 * <br>
 * 标题: 用户服务<br>
 * 描述: 用户服务<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
public interface UserService {

    /**
     * 通过用户ID查询用户信息
     * @param id 用户ID
     * @return 用户信息
     */
	User geUserById(Long id) ;
	
}
