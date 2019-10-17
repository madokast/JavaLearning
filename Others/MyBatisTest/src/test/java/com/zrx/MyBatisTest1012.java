package com.zrx;

import com.zrx.dao.IUserDao;
import com.zrx.domain.User;
import com.zrx.domain.UserX;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest1012 {
    private IUserDao userDao;
    private SqlSession sqlSession;

    @Test
    public void testFindAllX(){
        final List<UserX> allX = userDao.findAllX();
        for (UserX x : allX) {
            System.out.println("x = " + x);
        }
        //x = UserX{userId=null, userName='老王', userBirthday=null, userSex='null', userAddress='null'}
        //x = UserX{userId=null, userName='老1', userBirthday=null, userSex='null', userAddress='null'}
        //x = UserX{userId=null, userName='老2', userBirthday=null, userSex='null', userAddress='null'}
    }

    @Test
    public void testFindTotal(){
        final int total = userDao.findTotal();
        System.out.println("total = " + total);
    }

    @Test
    public void testFindByName(){
        final List<User> name = userDao.findByName("z%");
        for (User user : name) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById(){
        final User byId = userDao.findById(52);
        System.out.println(byId);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(53);
        sqlSession.commit();
    }

    @Test
    public void testUpdateUser(){
        final User user = new User();
        user.setId(53);
        user.setUsername("bbbbbbb");
        user.setBirthday(new Date(System.currentTimeMillis()-1000*60*60*24));
        user.setSex("m");
        user.setAddress("你");

        userDao.updateUser(user);
        sqlSession.commit();

        System.out.println("------all----------");
    }

    @Test
    public void testFindAll(){
        final List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
            for (byte aByte : user.getAddress().getBytes()) {
                System.out.print(String.format("%x ",aByte));
            }
            System.out.println();
        }
    }

    @Test
    public void testInsert() throws Exception{
        final User user = new User();
        user.setUsername("aaaaaa");
        user.setBirthday(new Date(System.currentTimeMillis()-1000*60*60*24));
        user.setSex("m");
        user.setAddress("你");


        System.out.println(user);

        userDao.saveUser(user);
        System.out.println(user);

        sqlSession.commit();
        System.out.println("------all----------");
    }

    @Before
    public void before()throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        this.sqlSession = factory.openSession();
        this.userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
