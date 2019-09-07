package filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 被访问了两次
 * FilterDemo07..@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
 * servletDemo01 被访问
 * FilterDemo07..@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
 * servletDemo02 被访问
 * FilterDemo07 退出
 * FilterDemo07 退出
 */

//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})//配置拦截路径
public class FilterDemo07 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo07..@WebFilter(value = \"/*\",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("FilterDemo07 退出");
    }

    @Override
    public void destroy() {

    }
}
