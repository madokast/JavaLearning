package Test.dao;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        final User loginUser = new User();
        loginUser.setUsername("zrx");
        loginUser.setPassword("1231");

        final UserDao userDao = new UserDao();
        final User user = userDao.login(loginUser);

        System.out.println("user = " + user);
    }
}
