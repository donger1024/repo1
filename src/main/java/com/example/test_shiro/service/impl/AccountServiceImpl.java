package com.example.test_shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.test_shiro.entity.Account;
import com.example.test_shiro.mapper.AccountMapper;
import com.example.test_shiro.service.AccountService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public Account findByUsername(String name) {
        QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
        wrapper.eq("username", name);
        Account account = mapper.selectOne(wrapper);
        return account;
    }

    @Override
    public void createAccount(Account account) {
        //随机生成salt值，并通过用户注册的密码和salt值经两次md5算法生成真实存储的密码
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String password= new SimpleHash("md5",account.getPassword(),salt,2).toString();
        account.setPassword(password);
        account.setSalt(salt);
        mapper.insert(account);
    }

}
