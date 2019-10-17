package com.zrx.dao;

import com.zrx.domain.Account;
import com.zrx.domain.AccountUser;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    List<AccountUser> findAllAccountUser();

    List<Account> findAccountByUid(Integer userId);
}
