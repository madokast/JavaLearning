package com.zrx.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 异常处理器
 */

public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常逻辑
     * @param httpServletRequest re
     * @param httpServletResponse res
     * @param handle 当前处理器对象
     * @param e 异常
     * @return
     */
    @Override
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object handle,
            Exception e) {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",e.getMessage());
        modelAndView.setViewName("exception");
        return modelAndView;

    }
}
