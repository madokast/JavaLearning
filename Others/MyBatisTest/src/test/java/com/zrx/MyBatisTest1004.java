package com.zrx;

import com.zrx.dao.IAccountDao;
import com.zrx.dao.IUserDao;
import com.zrx.domain.Account;
import com.zrx.domain.AccountUser;
import com.zrx.domain.User;
import com.zrx.domain.assist.Ids;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.plaf.metal.MetalLookAndFeel;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest1004 {
    private IUserDao userDao;
    private IAccountDao accountDao;
    private SqlSession sqlSession;

    @Test
    public void testCache(){
        final User byId = userDao.findById(56);
        System.out.println("byId = " + byId);

        byId.setUsername("zzzzzzzzzzzzzzz");
        System.out.println("byId = " + byId);

        sqlSession.clearCache();

        final User byId1 = userDao.findById(56);
        System.out.println("byId1 = " + byId1);

    }

    @Test
    public void testFindAllUser(){
        final List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println("user.setUsername(); = " + user.getUsername());
        }

        for (User user : all) {
            System.out.println("user = " + user);
        }

        final List<User> all2 = userDao.findAll();
        System.out.println("all2 = " + all2);
        final List<User> all3 = userDao.findAll();
        System.out.println("all3 = " + all3);
        sqlSession.clearCache();
        final List<User> all4 = userDao.findAll();
        System.out.println("all4 = " + all4);
    }

    @Test
    public void testFindAccountByUid(){
        final List<Account> accountByUid = accountDao.findAccountByUid(56);
        for (Account account : accountByUid) {
            System.out.println("account = " + account);
        }
        //2019-10-15 20:50:00,607 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger debug] DEBUG <==      Total: 1
        //User{id=56, username='bbbbbbb', birthday=Sat Oct 12 17:00:18 CST 2019, sex='m', address='浣�', accountList=null}
    }

    @Test
    public void testFindAllAccountUser(){
        final List<AccountUser> allAccountUser = accountDao.findAllAccountUser();
        for (AccountUser accountUser : allAccountUser) {
            System.out.println(accountUser);
        }

    }

    @Test
    public void testFindAll2(){
        final List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testFindAll()throws Exception{
        final List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println("---------------");
            System.out.println(account.getMoney());
        }
        Thread.currentThread().sleep(1000);

        System.out.println(all.get(1).getUser());
    }

    @Test
    public void testFindUserInIds(){
        final Ids ids = new Ids();

        final List<User> userInIds = userDao.findUserInIds(ids);
        System.out.println(userInIds);

        System.out.println("---------------");

        final ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(54);
        integers.add(55);
        integers.add(56);
        ids.setIds(integers);
        final List<User> userInIds1 = userDao.findUserInIds(ids);
        System.out.println(userInIds1);

    }

    @Test
    public void testFindUserByCondition(){
        final User user = new User();
        final List<User> userByCondition = userDao.findUserByCondition(user);
        for (User user1 : userByCondition) {
            System.out.println("user1 = " + user1);
        }
        System.out.println("-------------");

        user.setUsername("zrx");
        final List<User> userByCondition1 = userDao.findUserByCondition(user);
        for (User user1 : userByCondition1) {
            System.out.println("user1 = " + user1);
        }

    }

    @Before
    public void before()throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        this.sqlSession = factory.openSession();
        this.userDao = sqlSession.getMapper(IUserDao.class);
        this.accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
