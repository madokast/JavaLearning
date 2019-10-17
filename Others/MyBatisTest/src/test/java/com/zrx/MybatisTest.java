package com.zrx;

import com.zrx.dao.IUserDao;
import com.zrx.domain.User;
import com.zrx.mybatisImpl.io.Resources;
import com.zrx.mybatisImpl.io.session.SqlSession;
import com.zrx.mybatisImpl.io.session.SqlSessionFactory;
import com.zrx.mybatisImpl.io.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 读取配置文件
 * 创建 sqlSessionFactoryBuilder -> sqlSessionFactory
 * 代理 IUserDao
 * 使用
 * 释放资源
 */

public class MybatisTest {
    @Test
    public void test01(){
        System.out.println("测试");
    }


    @Test
    public void test() throws Exception{
        System.out.println("-----读配置文件-----");
        //读配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml"); // org.apache.ibatis.io.Resources
        //创建sql session factory -- 构建者模式
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //生成 sql session -- 工厂模式
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用sql session 动态代理 dao 接口  -- 代理模式
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //使用
        final List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        //Connected to the target VM, address: '127.0.0.1:59725', transport: 'socket'
        //User{id=41, username='老王', birthday=Tue Feb 27 17:47:03 CST 2018, sex='男', address='北京'}
        //User{id=42, username='老1', birthday=Mon Feb 27 17:47:03 CST 2017, sex='女', address='北京1'}
        //User{id=43, username='老2', birthday=Sat Feb 27 17:47:03 CST 2016, sex='男', address='北京2'}
        //User{id=44, username='老3', birthday=Fri Feb 27 17:47:03 CST 2015, sex='女', address='北京3'}
        //User{id=45, username='老4', birthday=Thu Feb 27 17:47:03 CST 2014, sex='男', address='北京4'}
        //Disconnected from the target VM, address: '127.0.0.1:59725', transport: 'socket'


        //释放资源
        sqlSession.close();
        in.close();
    }
}
