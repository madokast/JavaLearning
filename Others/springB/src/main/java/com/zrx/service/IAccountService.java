package com.zrx.service;

import com.zrx.demo.Account;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findById(Integer id);
}
