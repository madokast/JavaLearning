package filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//由web.xml配置
public class FilterDemo03 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("由web.xml配置");

        //不放行
//        filterChain.doFilter();
    }

    @Override
    public void destroy() {

    }
}
