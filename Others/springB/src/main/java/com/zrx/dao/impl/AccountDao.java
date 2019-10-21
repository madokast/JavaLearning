package com.zrx.dao.impl;

import com.zrx.dao.IAccountDao;
import com.zrx.demo.Account;
import com.zrx.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDao implements IAccountDao {
    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account findById(Integer id) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"update account set name = ?,money= ? where id = ?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 一个 返回
     * 0个 null
     * 多个 异常
     * @param name 账户名
     * @return
     */
    public Account findByName(String name) {
        try {
            List<Account> accounts =  runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?",
                    new BeanListHandler<Account>(Account.class),name);
            if(accounts==null||accounts.size()==0){
                return null;
            }
            if(accounts.size()>1){
                throw new RuntimeException("结果集不唯一");
            }

            return accounts.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
