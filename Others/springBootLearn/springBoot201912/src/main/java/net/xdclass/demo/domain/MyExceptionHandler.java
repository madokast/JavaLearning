package net.xdclass.demo.domain;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * 我写的异常处理
 * 捕获全局异常
 * <p>
 * Data
 * 2019/12/18 16:41
 *
 * @author zrx
 * @version 1.0
 */

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)//抓全局异常
    //{"msg":"/ by zero","code":100,"url":"/exception"}
    Object handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();

        map.put("code",100);
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURI());

        return map;
    }

    @ExceptionHandler(value = NullPointerException.class)
    Object handleNullPointerException(){
        Map<String,Object> map = new HashMap<>();

        map.put("code",100);
        map.put("msg","发生了 NullPointerException 异常");

        return map;
    }


    /**
     * 抓自定义异常
     */
    @ExceptionHandler(value = MyException.class)
    Object handleMyException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());

        return modelAndView;
    }
}
