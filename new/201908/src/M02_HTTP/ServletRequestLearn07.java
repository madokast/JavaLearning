package M02_HTTP;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 学习 request
 *    1.tomcat服务器会根据请求中的url中的资源路径，创建对应的servlet对象
 *    2.tomcat会创建两个对象——ServletRequest & ServletResponse
 *    3.把收到的全部请求消息都封装到 ServletRequest 中
 *    4.并把这两个对象传递给servlet的service方法
 *
 *    5.我们可以操作request对象获取请求消息
 *    6.同时通过response对象设置相应消息数据
 *
 *    7.最后tomcat读取response中的数据封装为http响应数据
 *
 *    关键点：这两个对象都是tomcat创建的，我们只需要使用它们
 *
 *      ServletRequest
 *          获取数据——
 *              请求行
 *                  get /demo007?name=abc
 *                  getMethod 获取请求方式
 *                  虚拟目录 getContextPath——201908_war_exploded
 *                  servlet路径 getServletPath——demo007
 *                  get的请求参数 getQueryString()
 *                  获取请求url 即 虚拟目录 + servlet路径 getRequestURI——/201908_war_exploded/demo007
 *                          getRequestURL —— http....
 *                  获取协议和版本 —— getProtocol
 *                  客户机IP地址 —— getRemoteAddr
 *
 *                  URL 统一资源定位符——定位：所以定死了
 *
 *                  URI 统一资源标识符——标识：是活的
 *
 *              请求头
 *                  getHeader(name)
 *                  getHeaderNames()
 *
 *              请求体
 *
 *
 *      ServletResponse
 */

@WebServlet("/demo007")
public class ServletRequestLearn07 extends HttpServlet {
    ServletRequest servletRequest;
    ServletResponse servletResponse;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求行
        if(false){
            //getMethod 获取请求方式
            // *                  虚拟目录 getContextPath——201908_war_exploded
            // *                  servlet路径 getServletPath——demo007
            // *                  get的请求参数 getQueryString()
            // *                  获取请求url 即 虚拟目录 + servlet路径 getRequestURI——/201908_war_exploded/demo007
            // *                          getRequestURL —— http....
            // *                  获取协议和版本 —— getProtocol
            // *                  客户机IP地址 —— getRemoteAddr

            System.out.println("req.getMethod() = " + req.getMethod());
            System.out.println("req.getContextPath() = " + req.getContextPath());
            System.out.println("req.getServletPath() = " + req.getServletPath());
            System.out.println("req.getQueryString() = " + req.getQueryString());
            System.out.println("req.getRequestURI() = " + req.getRequestURI());
            System.out.println("req.getRequestURL() = " + req.getRequestURL());
            System.out.println("req.getProtocol() = " + req.getProtocol());
            System.out.println("req.getRemoteAddr() = " + req.getRemoteAddr());
        }

        //请求头
        if(true){
            final Enumeration<String> headerNames = req.getHeaderNames();
            headerNames.asIterator().forEachRemaining(e->{
                System.out.println(e+"--"+req.getHeader(e));
            });
        }

    }
}
