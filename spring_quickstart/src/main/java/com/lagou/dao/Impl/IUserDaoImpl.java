package com.lagou.dao.Impl;

import com.lagou.dao.IUserDao;

public class IUserDaoImpl implements IUserDao {
    public void save() {
        System.out.println("dao被调用了...");
    }
}
