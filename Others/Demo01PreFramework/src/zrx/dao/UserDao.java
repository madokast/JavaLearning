package zrx.dao;

import zrx.domain.User;

import java.util.List;

/**
 * 用户操作的dao
 */

public interface UserDao {
    List<User> findAll();
}
