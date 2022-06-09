package com.example.test_shiro.service;

import com.example.test_shiro.entity.Account;

public interface AccountService {

    public Account findByUsername(String username);
    public void createAccount(Account account);

}
