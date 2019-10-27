package com.zrx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * restful风格学习
 *
 * 原来的形式：
 *      UserController  save()  update()  findAll()
 *      /user/save
 *      /user/update
 *      /user/findall
 * REST形式
 *      请求地址都一样，让不同的METHOD决定到底执行哪个方法
 *      /user + post
 *      /user + put
 *      /user + get
 * 好处：缓存？
 */


@Controller
@RequestMapping("/rest")
public class RestfulLearnController {

    @RequestMapping("/get/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("id = " + id);
        return "success";

        //rest 风格
    }

//    @ModelAttribute
    //在controller方法前执行

//    @SessionAttribute
    //存入session
}
