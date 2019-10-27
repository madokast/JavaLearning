package com.zrx.controller;

//控制器
//接收请求
import org.springframework.cglib.core.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.xml.crypto.Data;
import java.util.Date;

@Controller
public class HelloController {
    public HelloController(){
        System.out.println("HelloController init");
    }

//    private HandlerMapping mapping;

//    @RequestMapping(path = "/hello",value = "",method = {},params = {"username="}.)
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("hello SpringMVC");

        return "success";//提供success的jsp，还要配置视图解析器
    }

    @RequestMapping(path = "/getparams",method = {RequestMethod.GET,RequestMethod.POST})
    public String getParams(@RequestParam(name = "username") String aaa, String password, Date birthday,
                            @RequestBody String body){
        System.out.println("怎么拿到请求参数？");
        System.out.println("aaa = " + aaa);
        System.out.println("password = " + password);
        System.out.println("birthday = " + birthday);
        System.out.println("整个请求体 = " + body);
        return "success";
        //http://localhost:8080/zrx/getparams?username=zrx&password=12456
        //点评：强无敌

        //关于中文乱码问题
        //使用springMVC提供的过滤器，拦截request ，修改char encode

        //日期封装失败，因为字符串格式'2019-10-26'不能默认转为日期
        //解决方法：自定义类型转换器Converter

        //param名字和形参不一致，怎么办？
        //形参注解 @RequestParam(name = "username")

        //@RequestBody 拿到整个请求体，仅仅用于POST方法，用于后面的JSON
        //整个请求体 = username=%E5%93%88%E5%93%88&password=&birthday=2019-11-11&submit=%E6%8F%90%E4%BA%A4
    }
}
