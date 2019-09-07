package wordNew;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理法。牛逼
 */

@WebFilter("/wordNew/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("/wordNew/*");

        HttpServletResponse httpServletResponse = (HttpServletResponse)resp;
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;

        httpServletRequest.setCharacterEncoding("UTF-8");


        HttpServletRequest proxyReq = (HttpServletRequest) Proxy.newProxyInstance(
                httpServletRequest.getClass().getClassLoader(),
                httpServletRequest.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("getParameter")&&((String)args[0]).equals("body")){
                            final String body = httpServletRequest.getParameter("body");

                            return body==null? null: body.replaceAll("笨蛋","**");
                        }else {
                            return method.invoke(httpServletRequest,args);
                        }
                    }
                }
        );


        chain.doFilter(proxyReq, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
