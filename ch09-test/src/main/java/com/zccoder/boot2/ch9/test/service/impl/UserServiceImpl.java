package com.zccoder.boot2.ch9.test.service.impl;

import com.zccoder.boot2.ch9.test.dao.UserDao;
import com.zccoder.boot2.ch9.test.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccoder.boot2.ch9.test.service.CreditSystemService;
import com.zccoder.boot2.ch9.test.service.UserService;

/**
 * <br>
 * 标题: 用户服务实现<br>
 * 描述: 用户服务实现<br>
 * 时间: 2018/09/25<br>
 *
 * @author zc
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    Log log = LogFactory.getLog(this.getClass());
    @Autowired
    CreditSystemService creditSystemService;

    @Autowired
    UserDao userDao;

    @Override
    public int getCredit(int userId) {
        return creditSystemService.getUserCredit(userId);

    }

    @Override
    public boolean updateUser(User user) {
        int ret = userDao.updateById(user);
        return ret == 1;
    }

}
