package net.xdclass.demo.controller;

import net.xdclass.demo.domain.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * 异常处理
 * 配置全局异常
 * <p>
 * Data
 * 2019/12/17 22:54
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class ExceptionController {


    /**
     * @see net.xdclass.demo.domain.MyExceptionHandler
     *
     * http://localhost:8090/exception
     *
     * {"msg":"/ by zero","code":100,"url":"/exception"}
     *
     * @return 不应该返回
     */
    @GetMapping("/exception")
    public Object getException(){
        int i = 1/0;
        return "异常";
    }

    /**
     * 空指针异常
     * @see net.xdclass.demo.domain.MyExceptionHandler
     *
     * http://localhost:8090/npe
     *
     * {"msg":"发生了 NullPointerException 异常","code":100}
     *
     * @return 不应该
     */
    @GetMapping("/npe")
    public Object getNpe(){
        String s = null;
        boolean b =  s.equals("a");
        return b;
    }


    /**
     * 异常页面跳转
     * @see net.xdclass.demo.domain.MyExceptionHandler
     */
    @GetMapping("/exception/page")
    public Object getExceptionPage(){
        throw new MyException("100","异常页面跳转");
    }
}
