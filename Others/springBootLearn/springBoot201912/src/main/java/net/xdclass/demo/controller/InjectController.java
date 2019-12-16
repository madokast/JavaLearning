package net.xdclass.demo.controller;

import net.xdclass.demo.domain.InjectObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * bean 注入
 * <p>
 * Data
 * 2019/12/15 22:35
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@PropertySource("classpath:inject.properties")
public class InjectController {

    @Autowired
    private InjectObject injectObject;

    @GetMapping("/inject")
    public Object inject(){
//        System.out.println(injectObject);
        return injectObject;
    }
}
