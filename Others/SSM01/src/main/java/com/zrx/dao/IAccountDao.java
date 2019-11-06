package com.zrx.dao;

import com.zrx.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 不用写实现类了哈哈哈
 */
@Repository("accountDao")
public interface IAccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account(name, money) values(#{name}, #{money})")
    void saveAccount(Account account);
}
