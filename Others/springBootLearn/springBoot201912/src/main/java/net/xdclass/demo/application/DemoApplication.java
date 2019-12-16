package net.xdclass.demo.application;

import net.xdclass.demo.controller.SampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
public class DemoApplication {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(DemoApplication.class,args);
    }
}
