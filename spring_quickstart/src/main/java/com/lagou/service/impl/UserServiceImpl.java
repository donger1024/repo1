package com.lagou.service.impl;

import com.lagou.dao.IUserDao;
import com.lagou.service.UserService;

public class UserServiceImpl implements UserService {

    private IUserDao userDao;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
