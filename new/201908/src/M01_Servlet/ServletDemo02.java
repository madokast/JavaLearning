package M01_Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * ideaJ 和 tomcat 配置
 * Using CATALINA_BASE:   "C:\Users\madokast\.IntelliJIdea2019.1\system\tomcat\_new"
 *
 * 项目存储在两个地方：工作空间项目 和 tomcat的web项目
 * tomcat 访问 tomcat的web项目
 * WEB-INF下的资源不能被浏览器直接访问
 * tomcat下的端点调试
 */

@WebServlet("/demo002")
public class ServletDemo02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("servlet3.0来了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
