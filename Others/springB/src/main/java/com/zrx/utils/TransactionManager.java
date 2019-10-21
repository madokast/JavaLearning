package com.zrx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * start
 * commit
 * rollback
 * close
 */

@Component
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    @Autowired
    public void setConnectionUtils(ConnectionUtils connectionUtils){
        this.connectionUtils=connectionUtils;
    }


    public void beginTransacion(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void close(){
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();//解绑!!!!!!!!
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
