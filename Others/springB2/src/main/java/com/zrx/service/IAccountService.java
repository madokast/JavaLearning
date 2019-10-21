package com.zrx.service;

import com.zrx.Domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findById(Integer id);

    void transfer(String source,String target,Float money);
}
