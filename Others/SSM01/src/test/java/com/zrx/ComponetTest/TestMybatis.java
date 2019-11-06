package com.zrx.ComponetTest;


import com.zrx.dao.IAccountDao;
import com.zrx.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMybatis {
    @Test
    public void run01()throws Exception{
        final InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfigDeletable.xml");

        final SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        final SqlSession sqlSession = build.openSession(false);

        final IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);

        final List<Account> all = accountDao.findAll();
        System.out.println("all = " + all);

        final Account account = new Account();
        account.setMoney(123.1);
        account.setName("ssm2");
        accountDao.saveAccount(account);
        sqlSession.commit();

        sqlSession.close();
        resourceAsStream.close();
    }

}
