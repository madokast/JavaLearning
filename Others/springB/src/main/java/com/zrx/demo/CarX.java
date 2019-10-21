package com.zrx.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


//@Component
//@Repository
//@Controller
//@Service

//@Autowired 类型注入。多个
//@Qualifier 类型注入且id名匹配。不能独立使用
//@Resource id注入
//@Value() 注入基本类型 string

//@Scope singleton prototype



@Component(value = "carX")
@Scope("singleton")
public class CarX {
    @Value("carxxxxx")
    private String name;

    @PostConstruct
    public void init(){
//        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
//        System.out.println("destroy");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarX{" +
                "name='" + name + '\'' +
                '}';
    }
}
