package com.smart.cacheLearn;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component()
public class CacheSpring {

    @Cacheable(cacheNames = "cacheL")
    public String getByID(int id){
        System.out.println("开始查询");
        return getByIDFromDB(id);
    }

    private String getByIDFromDB(int id){
        System.out.println("在数据库中查询");
        return id + ":::" + id;
    }
}
