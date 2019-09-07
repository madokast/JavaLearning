package CheckUser.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;

/**
 * 完成登陆验证
 *
 * 判断用户是否登陆
 * 登陆——放行
 * 没有——跳转到登陆截面
 */

@WebFilter("/user/*")
public class CheckUserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("CheckUserFilter");

        final ArrayList<String> errors = new ArrayList<>();

        //判断是否是登陆相关资源
        //获取请求资源路径url
        HttpServletRequest request = (HttpServletRequest)req;
        request.setAttribute("errors", errors);


        final String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        if(requestURI.contains("loginServlet")){
            //用户就是想登陆，放行
            chain.doFilter(req, resp);
        }
        else {
            //判断用户是否登陆
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //已登录
                if (requestURI.contains(".jsp")){
                    //静止直接访问jsp
                    errors.add("禁止直接访问JSP");
                    request.getRequestDispatcher("/user/welcome.jsp").forward(request,(HttpServletResponse)resp);
                }else {
                    chain.doFilter(req, resp);
                }


            }else {
                //没有登陆
                errors.add("您尚未登陆，请登录");
                request.getRequestDispatcher("/user/loginServlet").forward(request,(HttpServletResponse)resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
