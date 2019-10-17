package com.zrx.dao.impl;

import com.zrx.dao.IUserDao;
import com.zrx.domain.User;
import com.zrx.domain.UserX;
import com.zrx.domain.assist.Ids;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public void setFactory(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        return null;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {

    }

    public User findById(Integer userId) {
        return null;
    }

    public List<User> findByName(String username) {
        return null;
    }

    public int findTotal() {
        return 0;
    }

    public List<UserX> findAllX() {
        return null;
    }

    public List<User> findUserByCondition(User user) {
        return null;
    }

    public List<User> findUserInIds(List<Integer> ids) {
        return null;
    }

    public List<User> findUserInIds(Ids ids) {
        return null;
    }
}
