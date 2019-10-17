package com.zrx.dao;

//持久层接口
//也可以叫做 IUserMapper

import com.zrx.domain.User;
import com.zrx.domain.UserX;
import com.zrx.domain.assist.Ids;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User findById(Integer userId);

    List<User> findByName(String username); //userDao.findByName("z%");

    int findTotal();

    List<UserX> findAllX();

    List<User> findUserByCondition(User user);//user 选择性的null有无

    List<User> findUserInIds(Ids ids);
}
