package net.xdclass.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description
 * 自定义Filter
 *
 * 需要在启动类
 * @see net.xdclass.demo.application.DemoApplication
 * 上添加注解：
 * @ServletComponentScan(basePackages = "net.xdclass.demo") // 这样才会加载我写的filter MyFilter
 *
 * servlet 3.0 哇哇哇
 * <p>
 * Data
 * 2019/12/18 20:26
 *
 * @author zrx
 * @version 1.0
 */

//@WebFilter(urlPatterns = "/*", filterName = "myfilter")
public class MyFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("自定义过滤器MyFilter初始化");
        //2019-12-18 20:46:02.321  INFO 26348 --- [  restartedMain] net.xdclass.demo.filter.MyFilter         : 自定义过滤器MyFilter初始化

    }

    @Override
    public void destroy() {
        LOG.info("自定义过滤器MyFilter销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LOG.info("自定义过滤器MyFilter收到{}", ((HttpServletRequest) request).getRequestURI());

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //2019-12-18 20:46:41.366  INFO 26348 --- [nio-8090-exec-1] net.xdclass.demo.filter.MyFilter         : 自定义过滤器MyFilter收到/inject
        chain.doFilter((HttpServletRequest) request, (HttpServletResponse) response);
    }
}
