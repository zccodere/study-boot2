package com.zccoder.boot2.ch9.test.service;

import com.zccoder.boot2.ch9.test.entity.User;

/**
 * <br>
 * 标题: 用户服务<br>
 * 描述: 用户服务<br>
 * 时间: 2018/09/25<br>
 *
 * @author zc
 */
public interface UserService {
    /**
     * 获取积分
     *
     * @param userId ID
     * @return 积分
     */
    int getCredit(int userId);

    /**
     * 更新用户信息
     *
     * @param user 用户
     * @return 结果
     */
    boolean updateUser(User user);
}
