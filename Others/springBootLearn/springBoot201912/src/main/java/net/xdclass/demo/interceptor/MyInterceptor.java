package net.xdclass.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description
 * 拦截器
 * <p>
 * Data
 * 2019/12/18 21:16
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class MyInterceptor implements HandlerInterceptor {
    private final Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

    /**
     * 进入controller前
     * @param request r
     * @param response r
     * @param handler h
     * @return o
     * @throws Exception e
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("拦截器 preHandle");

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 调用controller后
     *
     * @param request r
     * @param response r
     * @param handler h
     * @param modelAndView m
     * @throws Exception e
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("拦截器 postHandle");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 完成controller 且完成 modle渲染
     * 一般用于资源清理
     * @param request r
     * @param response r
     * @param handler h
     * @param ex e
     * @throws Exception e
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("拦截器 afterCompletion");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
