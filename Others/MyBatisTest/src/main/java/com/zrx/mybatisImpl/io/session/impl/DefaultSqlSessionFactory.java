package com.zrx.mybatisImpl.io.session.impl;

import com.zrx.mybatisImpl.io.cgf.Configuration;
import com.zrx.mybatisImpl.io.session.SqlSession;
import com.zrx.mybatisImpl.io.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        DefaultSqlSession defaultSqlSession = new DefaultSqlSession();
        defaultSqlSession.setConfiguration(configuration);
        return defaultSqlSession;
    }
}
