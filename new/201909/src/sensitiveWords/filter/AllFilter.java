package sensitiveWords.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * request 对象增强？
 * 设计模式
 *      装饰模式
 *      代理模式——动态代理
 *
 * 代理模式
 *      真实对象：公司
 *      代理对象：代理商
 *      代理对象代理真是对象，达到增强真实对象的功能
 * 静态代理：有类文件
 * 动态代理：没有类文件，再内存中
 *      代理对象实现真实的接口
 *      Proxy.newInstance()
 *      增强方法
 *
 */

@WebFilter(urlPatterns = "/word/servlet")
public class AllFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("/word/*");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        request.setCharacterEncoding("UTF-8");

        final String[] bodies = request.getParameterValues("body");
        String[] newBody = new String[bodies.length];
        for (int i = 0; i < bodies.length; i++) {
            if(bodies[i].contains("坏蛋")){
                newBody[i] = bodies[i].replace("坏蛋","**");
            }else {
                newBody[i] = bodies[i];
            }
        }

        request.setAttribute("newBody",newBody);

        chain.doFilter(request,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
