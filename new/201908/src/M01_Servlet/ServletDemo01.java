package M01_Servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet
 * server applet
 * 运行在服务器端的小程序
 *
 * 就是java类，tomcat执行他。需要遵守一定的规则
 * servlet就是一个接口，实现它就好了
 *
 * 1. 创建JavaEE项目
 * 2. 实现servlet接口
 * 3. 实现抽象方法
 * 4. 配置servlet——java类映射为路径 Demo001
 *          在web.xml中配置
 *          <servlet>
 *                  <servlet-name>Demo01</servlet-name>
 *                  <servlet-class>M01_Servlet.ServletDemo01</servlet-class>
 *          </servlet>
 *
 *          <servlet-mapping>
 *                  <servlet-name>Demo01</servlet-name>
 *                  <url-pattern>/Demo001</url-pattern>
 *          </servlet-mapping>
 *  5. 访问
 *          http://localhost:8080/201908_war_exploded/Demo001
 *
 * servlet原理
 *  当服务器收到服务器的url请求后，会解析url路径，在web.xml中查找是否有对应的url-pattern，再找到class全类名
 *  然后反射加载创建对象，调用方法
 *
 * servlet 的生命周期 五个方法
 *     void init(ServletConfig var1) throws ServletException;
 *
 *     ServletConfig getServletConfig();
 *
 *     void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *
 *     String getServletInfo();
 *
 *     void destroy();
 * 生命周期
 *      init方法 只执行一次
 *      service多次
 *      destroy 一次
 *
 * 多个用户同时访问时，存在安全问题
 *  怎么解决？尽量不要在servlet中定义成员变量，用局部变量
 *  即使定义了，也不要修改
 *
 * servlet3.0 支持注解配置~
 * 不需要外部.xml了
 * 哇哇哇哇
 * 不需要web.xml了
 * 类上使用注解，经行配置
 */

public class ServletDemo01 implements Servlet {
    /**
     * 创建servlet时执行 只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ini。。。");

    }

    /**
     * 获得配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每次访问时都执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello,servlet");
    }

    /**
     * 获取servlet信息
     * 版本 作者
     * 一般不用
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁，在servlet被杀死时执行，在服务器正常关闭时执行
     * 只会执行一次
     * 只有正常关闭服务器才会执行
     * 在servlet被销毁之前执行
     */
    @Override
    public void destroy() {
        System.out.println("des。。。。");

    }
}
