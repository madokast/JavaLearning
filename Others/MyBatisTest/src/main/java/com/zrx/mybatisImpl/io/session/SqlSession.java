package com.zrx.mybatisImpl.io.session;

public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
