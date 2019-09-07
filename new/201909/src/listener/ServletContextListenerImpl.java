package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        /**
         * 一般用于加载资源文件
         */

        //拿到ServletContext
        final ServletContext servletContext = servletContextEvent.getServletContext();
        //拿到 <context-param>
        final String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        System.out.println("contextConfigLocation = " + contextConfigLocation);
        //获取真实地址
        final String realPath = servletContext.getRealPath(contextConfigLocation);
        System.out.println("realPath = " + realPath);
        //加载文件
        try {
            final FileInputStream fileInputStream = new FileInputStream(realPath);
            System.out.println("fileInputStream = " + fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //deimashita
        //contextConfigLocation = /WEB-INF/classes/applicationContext.xml
        //realPath = D:\Documents\GitHub\JavaLearning\new\out\artifacts\201909_war_exploded\WEB-INF\classes\applicationContext.xml
        //fileInputStream = java.io.FileInputStream@6ee1960f
        //ServletContext 被创建了


        //ServletContext 在服务器启动后自动创建
        System.out.println("ServletContext 被创建了");

        //06-Sep-2019 09:44:42.855 警告 [RMI TCP Connection(2)-127.0.0.1] org.apache.tomcat.util.descriptor.web.WebXml.setVersion Unknown version string [4.0]. Default version will be used.
        //ServletContext 被创建了
        //06-Sep-2019 09:44:46.187 信息 [RMI TCP Connection(2)-127.0.0.1] org.apache.jasper.servlet.TldScanner.scanJars At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
        //FilterDemo04 init
        //[2019-09-06 09:44:46,656] Artifact 201909:war exploded: Artifact is deployed successfully

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 要被销毁了");

        //ServletContext 要被销毁了
    }
}
