package zrx.service;

import zrx.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口也
 */

public interface UserService {
    /**
     * 查询所用用户信息
     * @return 所有用户信息
     */
    List<User> findAll();
}
