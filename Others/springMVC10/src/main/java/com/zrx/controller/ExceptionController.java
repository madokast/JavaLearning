package com.zrx.controller;

import com.zrx.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * springMVC 异常处理学习
 * 浏览器 - 前端控制器 - web - service - dao
 * <p>
 * 需要提供一个组建 —— 异常处理器。这样service上抛的异常不会丢到浏览器页面了
 * 这是再跳到友好页面
 * 注册到前端控制中
 *
 * 具体方法：
 *      编写自定义异常类
 *      编写异常处理器
 *      配置异常处理器
 */

@Controller
@RequestMapping(path = "/exception")
public class ExceptionController {
    /**
     * @return
     */
    @RequestMapping(path = "test1")
    public ModelAndView test1() throws SysException {

        try {
            int i = 1 / 0;
        }catch (Exception t){
            t.printStackTrace();
            throw new SysException("出现系统错误"+t.getMessage());
        }

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
