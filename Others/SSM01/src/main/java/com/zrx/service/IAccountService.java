package com.zrx.service;

import com.zrx.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    void saveAccount(Account account);
}
