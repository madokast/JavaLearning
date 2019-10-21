package com.zrx.dao.impl;

import com.zrx.demo.Account;
import com.zrx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountDaoJdbcTemplate")
public class AccountDaoJdbcTemplate implements IAccountService {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String FIND_ALL_SQL="SELECT * FROM account";

    public List<Account> findAll() {
        return jdbcTemplate.queryForList(FIND_ALL_SQL,Account.class);
    }

    public Account findById(Integer id) {
        return null;
    }

    public void transfer(String source, String target, Float money) {

    }
}
