package filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/a",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.REQUEST})//配置拦截路径
public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo01...@WebFilter(\"/a\")");
    }

    @Override
    public void destroy() {

    }
}
