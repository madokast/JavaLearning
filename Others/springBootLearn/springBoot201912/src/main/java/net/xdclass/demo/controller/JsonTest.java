package net.xdclass.demo.controller;

import net.xdclass.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description
 * 学习json
 * jackson
 * fastJson
 * Gson
 * Json-lib
 * <p>
 * Data
 * 2019/12/15 19:17
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class JsonTest {

    /**
     * 返回json
     * http://localhost:8080/json/get
     * {
     *     "name": "zrx",
     *     "age": 12,
     *     "pwd": "123456"
     * }
     *
     * 在pwd字段上加上注解 @JsonIgnore
     * {
     *     "name": "zrx",
     *     "age": 12
     * }
     *
     * 在时间上加上
     * @JsonFormat(pattern = "yyyy年MM月dd日 hh时mm分ss秒" ,locale = "zh", timezone = "GMT+8")
     *     private Date createTime;
     *
     * {
     *     "name": "zrx",
     *     "age": 12,
     *     "createTime": "2019年12月15日 07时31分40秒"
     * }
     *
     *
     * 别名
     * @JsonProperty("年龄")
     *     private int age;
     *
     * {
     *     "name": "zrx",
     *     "createTime": "2019年12月15日 07时33分07秒",
     *     "年龄": 12
     * }
     *
     *
     *
     * @return user
     */
    @GetMapping("/json/get")
    public Object get(){
//        return new User("zrx",12,"123456");
        return new User("zrx",12,"123456",new Date());

    }

}
