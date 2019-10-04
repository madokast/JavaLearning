package com.zrx.dao;

import com.zrx.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDaoAnno {
    @Select("select * from user")
    List<User> findAll();
}
