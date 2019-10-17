package com.zrx;

import com.zrx.dao.IAccountDao;
import com.zrx.dao.IUserDao;
import com.zrx.domain.Account;
import com.zrx.domain.User;
import com.zrx.domain.Userx;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Test1015 {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;

    @Test
    public void findAllTest2(){
        final List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user.getUsername());
        }

        for (User user : all) {
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void findAllATest(){
        final List<Account> all = accountDao.findAll();
        System.out.println("all = " + all);
    }

    @Test
    public void findByIdTest(){
        final User byId = userDao.findById(67);
        System.out.println("byId = " + byId);
    }

    @Test
    public void findAllXTest(){
        final List<Userx> allX = userDao.findAllX();
        System.out.println("allX = " + allX);
    }

    @Test
    public void findTotalTest(){
        System.out.println("userDao.findTotal() = " + userDao.findTotal());

    }

    @Test
    public void testFindByName(){
        final List<User> byName = userDao.findByName("%zrx%");
        System.out.println("byName = " + byName);
    }

    @Test
    public void testDeleteUser(){
        final User user = new User();
        user.setId(64);

        userDao.deleteUser(user);
        sqlSession.commit();
    }

    @Test
    public void testInsert(){
        final User user = new User();
        user.setUsername("insert anno");

        userDao.saveUser(user);
        sqlSession.commit();

        testFindAll();
    }

    @Test
    public void testFindAll(){
        final List<User> all = userDao.findAll();
        System.out.println("all = " + all);
    }

    @Before
    public void before()throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapCig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);
        in.close();
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
