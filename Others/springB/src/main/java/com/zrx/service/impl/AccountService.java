package com.zrx.service.impl;

import com.sun.javafx.collections.SourceAdapterChange;
import com.zrx.dao.IAccountDao;
import com.zrx.demo.Account;
import com.zrx.service.IAccountService;
import com.zrx.utils.TransactionManager;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 没有代理要疯了
 */

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private TransactionManager transactionManager;

    public List<Account> findAll() {
        try {
            // begin
            transactionManager.beginTransacion();
            //get
            final List<Account> all = accountDao.findAll();
            //commit
            transactionManager.commit();
            //return
            return all;
        }catch (Exception e){
            //rollback
            transactionManager.rollback();
            return null;
        }finally {
            //close
            transactionManager.close();
        }
    }

    public Account findById(Integer id) {
        try {
            // begin
            transactionManager.beginTransacion();
            //get
            final Account account = accountDao.findById(id);
            //commit
            transactionManager.commit();
            //return
            return account;
        }catch (Exception e){
            //rollback
            transactionManager.rollback();
            return null;
        }finally {
            //close
            transactionManager.close();
        }
    }

    public void transfer(String source, String target, Float money) {
        try {
            // begin
            transactionManager.beginTransacion();
            //get

            Account sourceAccount = accountDao.findByName(source);
            Account targetAccount = accountDao.findByName(target);

            System.out.println("sourceAccount = " + sourceAccount);
            System.out.println("targetAccount = " + targetAccount);

            System.out.println("money = " + money);

            sourceAccount.setMoney(sourceAccount.getMoney()-money);

            int[] a = new int[1];
            a[2] =3;
            System.out.println(a[2]);

            targetAccount.setMoney(targetAccount.getMoney()+money);

            System.out.println("sourceAccount = " + sourceAccount);
            System.out.println("targetAccount = " + targetAccount);


            accountDao.update(sourceAccount);
            accountDao.update(targetAccount);

            //commit
            transactionManager.commit();
        }catch (Exception e){
            //rollback
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //close
            transactionManager.close();
        }




    }
}
