package com.zrx;

import com.zrx.dao.IUserDaoAnno;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class IUserDaoAnnoTest {
    @Test
    public void test()throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        final SqlSessionFactory factory = builder.build(in);
        final SqlSession sqlSession = factory.openSession();

        final IUserDaoAnno daoAnno = sqlSession.getMapper(IUserDaoAnno.class);
        System.out.println(daoAnno.findAll());

        sqlSession.close();
        in.close();
    }
}
