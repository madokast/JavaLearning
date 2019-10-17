package com.zrx.mybatisImpl.io.session;

import com.zrx.mybatisImpl.io.cgf.Configuration;
import com.zrx.mybatisImpl.io.cgf.Mapper;
import com.zrx.mybatisImpl.io.session.impl.DefaultSqlSessionFactory;

import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactoryBuilder(){

    }

    public SqlSessionFactory build(InputStream in){

        System.out.println(in);

        try {
            ///////////////创建mapper
            Map<String,Mapper> mappers = new HashMap<String, Mapper>();

            String namespace = "com.zrx.dao.IUserDao";
            String id = "findAll";

            String key = namespace+"."+id;

            Mapper mapper = new Mapper();
            mapper.setQueryString("select * from mybatisT.user");
            mapper.setResultType("com.zrx.domain.User");

            mappers.put(key,mapper);

            /////////////////////////////

            final Configuration configuration = new Configuration();
            configuration.setDriver("com.mysql.jdbc.Driver");
            configuration.setPassword("123456");
            configuration.setUrl("jdbc:mysql://localhost:3306/mybatisT?serverTimezone=Asia/Shanghai");
            configuration.setUsername("root");

            configuration.setMappers(mappers);

            /////////////////////////////
            DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();
            sqlSessionFactory.setConfiguration(configuration);

            return sqlSessionFactory;


        }catch (Exception e){
            e.printStackTrace();
        return null;
        }
    }
}
