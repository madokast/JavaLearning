package net.xdclass.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Description
 * 复制粘贴，第一个spring boot hello world项目
 * <p>
 * Data
 * 2019/12/15 11:37
 *
 * @author zrx
 * @version 1.0
 */

@Controller
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello World!" + new Date();
    }
}