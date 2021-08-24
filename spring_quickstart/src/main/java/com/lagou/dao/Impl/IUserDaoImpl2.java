package com.lagou.dao.Impl;

import com.lagou.dao.IUserDao;

public class IUserDaoImpl2 implements IUserDao {

    @Override
    public void save() {
        System.out.println("dao被调用了");
    }
}
