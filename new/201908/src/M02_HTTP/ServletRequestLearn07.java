package M02_HTTP;

import Java并发编程的艺术.Tools.ArrayToList;
import Java并发编程的艺术.Tools.PrintMap;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
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
 *                  getHeader(name) 通过name获得value
 *                  getHeaderNames() 获得所有的请求头名称
 *
 *              请求体
 *            其他功能：
 *              非常常用!!
 *                  获取“请求参数”Query，通用  兼容get和post
 *                      getParameter(name)——根据参数名称获取名称，如 username
 *                      getParameterValues(name)——获取数组化的值，一般用于复选框
 *                      getParameterNames()获取所有的请求参数名称
 *                      getParameterMap() 分会一个map，装了所有请求参数的键值对
 *
 *                   ** 中文乱码问题
 *                      get 方式已经解决乱码
 *                      post 没有解决乱码
 *
 *                  请求转发
 *                      服务器内部的资源跳转方式
 *                      /day14 - A-servlet
 *                             - B-servlet
 *                      不同servlet跳转
 *
 *                      1. getRequsetDispatcher 请求转发器对象
 *                      2. forward(req,resp)
 *
 *                      特点：
 *                          浏览器的地址栏没有发生变换
 *                          转发是服务器内部资源调整的一直方式，只能访问当前服务器的内部资源
 *                          转发相对浏览器来说，只有一次请求
 *
 *                  共享数据
 *                      目的：上面的请求转发，具体来说是A-servlet收到了浏览器的请求，
 *                          然后自己处理了一部分数据，还有一部分交给B-servlet处理。
 *                          这时需要完成A B之间的通信。这就是共享数据
 *
 *                      域对象：有作用范围的对象，可以在范围内共享数据
 *                      request对象的作用域：只存在于请求转发中的servlet中
 *                          共享数据的方法
 *                          serAttribute(A servlet存储一些对象)然后B可以看到
 *                          getAttribute
 *                          removeAttribute
 *
 *                  获取servletContext对象
 *                      getServletContext
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
        if(false){
            final Enumeration<String> headerNames = req.getHeaderNames();
            headerNames.asIterator().forEachRemaining(e->{
                System.out.println(e+"--"+req.getHeader(e));
            });
        }

        //判断
        //解决浏览器的兼容问题
        if(false){
            System.out.println("demo007");
            final String header = req.getHeader("user-agent");
            System.out.println(header);
            if(header.contains("Chrome")){
                System.out.println("谷歌来了");
            }
        }

        //referer
        //我从哪里来
        if(false){
            final String referer = req.getHeader("referer");
            System.out.println(referer);
            //null
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("欢迎，你来自"+referer);
        }

        //更多的对请求参数的获取方法
        if(false){
            System.out.println("demo007");
            System.out.println("req.getParameter(\"username\") = " + req.getParameter("username"));

            System.out.println("-------------");
            req.getParameterNames().asIterator().forEachRemaining(System.out::println);

            System.out.println("-------------");
            final String[] hobbies = req.getParameterValues("hobby");
            System.out.println(ArrayToList.to(hobbies));
            System.out.println("-------------");

            System.out.println(req.getParameterMap());
            PrintMap.print(req.getParameterMap());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //直接读请求体
        if(false){System.out.println("demo007");
            System.out.println("-------获取请求体数据----------");
            //只有POST才有请求体
            //我们以流的形式获得请求体数据
            //有字符数据和字节数据之分

            //字符
            final BufferedReader reader = req.getReader();
            String s = null;
            while((s=reader.readLine())!=null){
                System.out.println(s);
            }


            //字节——文件上传
            final ServletInputStream inputStream = req.getInputStream();

        }
        //中文乱码问题
        if(true){
            req.setCharacterEncoding("UTF-8");

            final String username = req.getParameter("username");
            System.out.println("username = " + username);

//            final String s = new BufferedReader(new InputStreamReader(req.getInputStream(), "UTF-8")).readLine();
//            System.out.println(s);
//            System.out.println(URLDecoder.decode(s,"UTF-8"));

        }
    }
}
