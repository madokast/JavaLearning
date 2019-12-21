package net.xdclass.demo.webMvcConfigurer;

import net.xdclass.demo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description
 * 配置拦截器
 * <p>
 * Data
 * 2019/12/18 21:07
 *
 * @author zrx
 * @version 1.0
 */

//@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private HandlerInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/*");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
