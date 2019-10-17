package com.zrx;

import com.zrx.dao.IUserDao;
import com.zrx.dao.impl.UserDaoImpl;
import com.zrx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class DaoImplTest {
    @Test
    public void test() throws Exception{
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
////
////        final SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
////        final SqlSessionFactory factory = builder.build(inputStream);
////
////        UserDaoImpl userDao = new UserDaoImpl();
////        userDao.setFactory(factory);
////
////        final List<User> all = userDao.findAll();
////        System.out.println(all);
////
////        inputStream.close();
    }
}
