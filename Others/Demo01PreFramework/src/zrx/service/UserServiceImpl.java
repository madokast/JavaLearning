package zrx.service;

import zrx.dao.UserDao;
import zrx.dao.UserDaoImpl;
import zrx.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }
}
