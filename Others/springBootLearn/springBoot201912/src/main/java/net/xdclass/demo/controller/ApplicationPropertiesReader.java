package net.xdclass.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description
 * 读取配置文件 application properties
 * <p>
 * Data
 * 2019/12/15 21:25
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@PropertySource("classpath:application.properties")
public class ApplicationPropertiesReader {


    @Value("${someInformation}")
    String someInformation;

    /**
     *
     * http://localhost:8080/properties
     *
     * someInformationFromApplicationProperties
     * 读取成功
     * @return ${someInformation}
     */
    @GetMapping(path = "/properties")
    public Object getProperties(){
        return someInformation + "触发器热部署";
    }

}
