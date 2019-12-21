package net.xdclass.demo.controller;

import net.xdclass.demo.domain.InjectObject;
import org.jetbrains.annotations.Contract;
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


    private final InjectObject injectObject;

    @GetMapping("/inject")
    public Object inject(){
//        System.out.println(injectObject);
        return injectObject;
    }


    // pure ?
    // 这个属性听名字都能猜出什么意思——
    // 表示被注解的函数（就是方法，包含普通
    // 方法、静态方法和构造方法，下同）是否为纯函数。
    //纯函数（好像）是一个 fp 里面的概念，如果一个函数，
    // 对于特定的输入，都将产生对应的唯一的输出，并且不
    // 会影响别的东西（即没有副作用），那么这个函数就是
    // 纯函数。 数学上的函数就是最标准的纯函数，比如我
    // 有一个 f(x) ，那么对应每一个 x ，这个函数的输出都
    // 有一个对应的 f(x) ，并且我多次输入同一个 x ，输出
    // 的 f(x) 也是同一个。 这就是一个纯函数。
    @org.jetbrains.annotations.Contract(pure = true)
    //这就是传说中的构造器注入?
    @Autowired
    public InjectController(InjectObject injectObject){
        this.injectObject = injectObject;
    }

    //构造器注入
    //<bean id="person" class="cn.xh.dao.Person">
    // <constructor-arg name="pid" value="1"></constructor-arg>
    // <constructor-arg name="pname" value="张三"></constructor-arg>
    // <constructor-arg name="age" value="18"></constructor-arg>
    //</bean>
    //

    //setter 注入
    //<bean id="person" class="cn.xh.dao.Person">
    // <property name="pid" value="1"></property>
    // <property name="pname" value="张三"></property>
    // <property name="age" value="18"></property>
    //</bean>
    //

    //

}
