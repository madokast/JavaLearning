package filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.ObjectInputFilter;

@WebFilter("/test090501.jsp")
public class FilterDemo04 implements Filter {
    public void destroy() {
        System.out.println("FilterDemo04 destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo04 doFilter进入");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo04 doFilter退出");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterDemo04 init");
    }

}
