package com.zrx.dao.impl;

import com.zrx.dao.IAccountDao;
import com.zrx.Domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDao extends JdbcDaoSupport implements IAccountDao {



    public List<Account> findAll() {
        return getJdbcTemplate().query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findById(Integer id) {
        List<Account> accounts  = getJdbcTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),id);

        return accounts.isEmpty()?null:accounts.get(0);
    }

    public void update(Account account) {
        getJdbcTemplate().update("update account set name = ?,money= ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }

    /**
     * 一个 返回
     * 0个 null
     * 多个 异常
     * @param name 账户名
     * @return
     */
    public Account findByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);

        if(accounts==null||accounts.size()==0){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }
}
