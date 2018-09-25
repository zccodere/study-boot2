package com.zccoder.boot2.ch9.test.service.impl;

import org.springframework.stereotype.Service;

import com.zccoder.boot2.ch9.test.service.CreditSystemService;

/**
 * <br>
 * 标题: 积分系统服务实现<br>
 * 描述: 积分系统服务实现<br>
 * 时间: 2018/09/25<br>
 *
 * @author zc
 */
@Service
public class CreditSystemServiceImpl implements CreditSystemService {

    @Override
    public int getUserCredit(int userId) {
        throw new UnsupportedOperationException("积分系统未完成，不能调用");
    }

    @Override
    public boolean addCedit(int userId, int score) {
        throw new UnsupportedOperationException("积分系统未完成，不能调用");
    }

}
