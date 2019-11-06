package com.zrx.service.impl;

import com.zrx.dao.IAccountDao;
import com.zrx.domain.Account;
import com.zrx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("accountService:findAll");
        return accountDao.findAll();
//        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("accountService:saveAccount");
        accountDao.saveAccount(account);
    }
}
