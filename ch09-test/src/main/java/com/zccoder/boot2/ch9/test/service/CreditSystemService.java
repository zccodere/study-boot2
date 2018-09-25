package com.zccoder.boot2.ch9.test.service;

/**
 * <br>
 * 标题: 积分系统服务<br>
 * 描述: 积分系统服务<br>
 * 时间: 2018/09/25<br>
 *
 * @author zc
 */
public interface CreditSystemService {
    /**
     * 获取积分
     *
     * @param userId ID
     * @return 积分
     */
    int getUserCredit(int userId);

    /**
     * 增加积分
     *
     * @param userId ID
     * @param score  分数
     * @return 结果
     */
    boolean addCedit(int userId, int score);
}
