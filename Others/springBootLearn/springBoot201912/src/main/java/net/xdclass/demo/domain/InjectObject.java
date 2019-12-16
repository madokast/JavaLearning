package net.xdclass.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description
 * InjectObject
 * 配置文件注入
 * <p>
 * Data
 * 2019/12/15 22:36
 *
 * @author zrx
 * @version 1.0
 */

@Component
@PropertySource("classpath:application.properties")
public class InjectObject {

    @Value("${inject.object.name}")
    private String name;

    @Value("${inject.object.age}")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
