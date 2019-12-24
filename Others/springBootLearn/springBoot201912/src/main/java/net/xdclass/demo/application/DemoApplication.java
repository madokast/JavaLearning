package net.xdclass.demo.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
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
@EnableScheduling //定时任务扫描
@EnableAsync //开启异步任务支持
@EnableJms //支持java消息服务 -> 消息队列
public class DemoApplication {
    public static void main(String[] args) throws Exception {

        final ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);

//        ((SpringApplication)run).setWebApplicationType(WebApplicationType.REACTIVE);

    }


    //其他学习
    //默认过滤器
    CharacterEncodingFilter characterEncodingFilter;
    HiddenHttpMethodFilter hiddenHttpMethodFilter;
    HttpPutFormContentFilter httpPutFormContentFilter;
    RequestContextFilter requestContextFilter;

    //过滤器优先级
}
