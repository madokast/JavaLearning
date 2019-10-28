package com.zrx.dao;

import com.zrx.domain.Account;

import java.util.List;

/**
 * 不用写实现类了哈哈哈
 */

public interface IAccountDao {
    List<Account> findAll();

    void saveAccount(Account account);
}
