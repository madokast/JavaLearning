package net.xdclass.demo.application;

import net.xdclass.demo.controller.SampleController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.filter.RequestContextFilter;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/12/15 14:45
 *
 * @author zrx
 * @version 1.0
 */

/**
 * 一个集成的注解，扫描包也在里面
 * 相当于
 * //@Configuration
 * //@EnableAutoConfiguration
 * //@ComponentScan
 */
@SpringBootApplication(scanBasePackages = "net.xdclass.demo")
@ServletComponentScan(basePackages = "net.xdclass.demo") // 这样才会加载我写的filter MyFilter
@MapperScan(basePackages = "net.xdclass.demo.mapper") // 扫描的map包
public class DemoApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }


    //其他学习
    //默认过滤器
    CharacterEncodingFilter characterEncodingFilter;
    HiddenHttpMethodFilter hiddenHttpMethodFilter;
    HttpPutFormContentFilter httpPutFormContentFilter;
    RequestContextFilter requestContextFilter;

    //过滤器优先级
}
