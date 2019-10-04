package com.zrx.dao;

//持久层接口

import com.zrx.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
