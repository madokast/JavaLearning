package com.zrx.controller;

//控制器
//接收请求
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    public HelloController(){
        System.out.println("HelloController init");
    }

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello SpringMVC");

        return "success";//提供success的jsp，还要配置视图解析器
    }
}
