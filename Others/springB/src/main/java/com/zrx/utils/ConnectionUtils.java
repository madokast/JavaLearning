package com.zrx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class ConnectionUtils {
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    private DataSource dataSource ;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){
        Connection connection = connectionThreadLocal.get();
        if(connection==null){
            try {
                connection  = dataSource.getConnection();
            }catch (Exception e){
                e.printStackTrace();
                throw new Error();
            }
            connectionThreadLocal.set(connection);
        }

        return connection;
    }

    public void removeConnection(){
        connectionThreadLocal.remove();
    }
}
