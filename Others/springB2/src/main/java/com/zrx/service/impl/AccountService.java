package com.zrx.service.impl;

import com.sun.javafx.iio.ios.IosImageLoaderFactory;
import com.zrx.Domain.Account;
import com.zrx.dao.IAccountDao;
import com.zrx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        final List<Account> all = accountDao.findAll();
        return all;
    }

    public Account findById(Integer id) {
        final Account account = accountDao.findById(id);
        return account;
    }

    public void transfer(String source, String target, Float money) {


        Account sourceAccount = accountDao.findByName(source);
        Account targetAccount = accountDao.findByName(target);

        System.out.println("sourceAccount = " + sourceAccount);
        System.out.println("targetAccount = " + targetAccount);

        System.out.println("money = " + money);

        sourceAccount.setMoney(sourceAccount.getMoney() - money);

        targetAccount.setMoney(targetAccount.getMoney() + money);

        System.out.println("sourceAccount = " + sourceAccount);
        System.out.println("targetAccount = " + targetAccount);


        accountDao.update(sourceAccount);

        int i = 1/0;

        accountDao.update(targetAccount);


    }
}
