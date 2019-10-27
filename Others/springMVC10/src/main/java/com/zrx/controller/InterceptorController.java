package com.zrx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Action;

/**
 * 拦截器
 * 很类似于过滤器
 *
 * 但是这是springMVC才有的东西
 *
 * 方法：
 *      编写拦截器类，实现接口
 *      配置之
 *
 *          <!--    配置拦截器-->
 *     <mvc:interceptors>
 *         <mvc:interceptor>
 *             <!--            要拦截的方法-->
 *             <mvc:mapping path="/interceptor/*"/>
 *             <!--            具体的拦截器-->
 *             <bean id="myInterceptor01" class="com.zrx.interceptor.MyInterceptor01"/>
 *         </mvc:interceptor>
 *     </mvc:interceptors>
 *
 *
 */

@Controller
@RequestMapping(path = "/interceptor")
public class InterceptorController {

    @RequestMapping(path = "/test01")
    public String test01(){
        System.out.println("InterceptorController");
        return "success";
    }

}
