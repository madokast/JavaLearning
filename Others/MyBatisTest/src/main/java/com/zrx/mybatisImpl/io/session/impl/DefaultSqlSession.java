package com.zrx.mybatisImpl.io.session.impl;

import com.zrx.mybatisImpl.io.cgf.Configuration;
import com.zrx.mybatisImpl.io.session.SqlSession;

import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    //代理
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        T o = null;
        o = (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        final String methodName = method.getName();
                        final Class<?> clazz = method.getDeclaringClass();
                        final String clazzName = clazz.getName();

                        final String resultType = configuration.getMappers().get(clazzName + "." + methodName).getResultType();
                        final String queryString = configuration.getMappers().get(clazzName + "." + methodName).getQueryString();

                        final Class<?> resultClass = Class.forName(resultType);

                        final Constructor<?> constructor = resultClass.getConstructor();
                        final Field[] fields = resultClass.getDeclaredFields();

                        List<Object> list = new ArrayList<Object>();

                        try {
                            Class.forName(configuration.getDriver());

                            final Connection connection = DriverManager.getConnection(configuration.getUrl(),
                                    configuration.getUsername(), configuration.getPassword());

                            final PreparedStatement preparedStatement = connection.prepareStatement(queryString);

                            final ResultSet resultSet = preparedStatement.executeQuery();

                            while (resultSet.next()){
                                final Object newInstance = constructor.newInstance();

                                for (Field field : fields) {
                                    System.out.println("insert!inject!");
                                    final String fieldName = field.getName();
                                    final Class<?> type = field.getType();

                                    if(type.equals(String.class)){
                                        final String string = resultSet.getString(fieldName);
                                        field.setAccessible(true);
                                        field.set(newInstance,string);
                                    }else if(type.equals(Integer.class)){
                                        final int anInt = resultSet.getInt(fieldName);
                                        field.setAccessible(true);
                                        field.set(newInstance,anInt);
                                    }
                                }
                                list.add(newInstance);
                            }

                            resultSet.close();
                            preparedStatement.close();
                            connection.close();

                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        return list;
                    }
                });


        return o;
    }

    //释放资源
    public void close() {
        // do nothing
    }
}
