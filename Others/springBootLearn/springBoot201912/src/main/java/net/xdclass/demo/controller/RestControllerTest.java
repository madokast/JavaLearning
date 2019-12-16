package net.xdclass.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * 学习 @RestController
 * Spring 3.x 或使用@Controller情况下，
 * 在方法上使用@ResponseBody注释时，
 * Spring会转换返回值并自动将其写入HTTP响应。
 *
 * Spring 4.0引入了@RestController，
 * 这是一个控制器的专用版本，它是一个方便的注释，
 * 除了自动添加@Controller和@ResponseBody注释之外没有其他新魔法。
 * <p>
 * Data
 * 2019/12/15 15:03
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class RestControllerTest {
    @RequestMapping("/restcontrollertest")
//    @ResponseBody 自动添加
    Map<String,String> test(){
        Map<String,String> map = new HashMap<>();
        map.put("name","xdclass");
        return map;
    }
}
