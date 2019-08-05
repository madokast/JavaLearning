package M04_HTTP_And_Response;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ServletContext 对象
 *  代表整个web应用，可以和程序的容器(即服务器tomcat)通讯
 *  例如让servlet可以——获取文件的mime类型、转发请求、写日志
 *  一个服务器只有一个context对象，一个jvm虚拟机也只有一个context对象
 *
 *  主要用途，
 *      获取MIME类型，
 *      获取域对象，
 *      获取文件的真实路径(服务器路径)
 *
 *  获取方式
 *      this.getServletContext();
 *      req.getServletContext();
 *
 *  MIME类型
 *      格式：大类型/小类型
 *      实例：text/html   image/jpeg
 *      发送数据前需要获取数据的MIME类型
 *
 *    servletContextThis.getMimeType("")
 *    为什么可以获取到，再tomcat安装文件夹conf包下由web.xml 所有其他的web.xml都继承于这个文件
 *    里面有——
 *          <mime-mapping>
 *              <extension>apk</extension>
 *              <mime-type>application/vnd.android.package-archive</mime-type>
 *          </mime-mapping>
 *     如上的map一大堆，约1000个
 *
 *
 *  获取域对象，用于共享数据 键值对
 *      servletContextThis.setAttribute();
 *      servletContextThis.getAttribute();
 *      servletContextThis.removeAttribute();
 *  可见范围？
 *      整个服务器内部，所有用户的数据
 *
 *
 *  获取文件的真实路径
 *      web项目存在两个地方——tomcat服务器 / 本地工作空间
 *      真实路径，即文件运行路径
 *
 *      getRealPath()
 */

@WebServlet("/contextServlet")
public class ContextServlet extends HttpServlet {
//    ServletContext

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("contextServlet");
        resp.setContentType("text/html;charset=utf-8");


        final ServletContext servletContextReq = req.getServletContext();
        final ServletContext servletContextThis = this.getServletContext();

        System.out.println("servletContextReq = " + servletContextReq);
        System.out.println("servletContextThis = " + servletContextThis);
        //servletContextReq = org.apache.catalina.core.ApplicationContextFacade@12b1440c
        //servletContextThis = org.apache.catalina.core.ApplicationContextFacade@12b1440c

        final ServletContext servletContext = this.getServletContext();

        //获取MIME类型
        if(true){
            final String mimeType = servletContextThis.getMimeType("abc.jpg");
            resp.getWriter().write(mimeType);
            resp.getWriter().write("<br>");
        }

        //获取域对象，共享数据
        if(false){
//            servletContextThis.setAttribute();
//            servletContextThis.getAttribute();
//            servletContextThis.removeAttribute();

            String key = "contextServlet0805";

            resp.getWriter().write("you quest:"+req.getQueryString());

            servletContextThis.setAttribute(key,req.getQueryString());
        }

        //getRealPath
        if(true){
            //读取配置文件？
            //三个地方可以放配置文件

            // 1. 在src下 D:\Documents\GitHub\JavaLearning\new\201908\src\fileInSrc.txt
            // 2. 在web下 D:\Documents\GitHub\JavaLearning\new\201908\web\fileInWeb.txt
            // 3. 放在WEB-INF下 D:\Documents\GitHub\JavaLearning\new\201908\web\WEB-INF\fileInWebInf.txt

            //加载web目录下文件 fileInWeb.txt
            String realPathForFileInWeb = servletContext.getRealPath("fileInWeb.txt");
            File file = new File(realPathForFileInWeb);
            resp.getWriter().write("realPathForFileInWeb"+"<br>");
            resp.getWriter().write(realPathForFileInWeb+"<br>");
            resp.getWriter().write(file+"<br>");
            System.out.println("file.exists() = " + file.exists());


            String realPathForFileInWebInf = servletContext.getRealPath("WEB-INF/fileInWebInf.txt");
            file = new File(realPathForFileInWebInf);
            resp.getWriter().write("realPathForFileInWebInf"+"<br>");
            resp.getWriter().write(realPathForFileInWebInf+"<br>");
            resp.getWriter().write(file+"<br>");
            System.out.println("file.exists() = " + file.exists());

            //这个写法错误!!
            String realPathForFileInSrc = servletContext.getRealPath("fileInSrc.txt");
            file = new File(realPathForFileInSrc);
            resp.getWriter().write("realPathForFileInSrc"+"<br>");
            resp.getWriter().write(realPathForFileInSrc+"<br>");
            resp.getWriter().write(file+"<br>");
            System.out.println("file.exists() = " + file.exists());

            final String realPath = servletContext.getRealPath("/WEB-INF/classes/fileInSrc.txt");
            final File file1 = new File(realPath);
            System.out.println("file.exists() = " + file1.exists());

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

//    {
//        new Servlet(){
//            @Override
//            public void init(ServletConfig servletConfig) throws ServletException {
//
//            }
//
//            @Override
//            public ServletConfig getServletConfig() {
//                return null;
//            }
//
//            @Override
//            public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//
//            }
//
//            @Override
//            public String getServletInfo() {
//                return null;
//            }
//
//            @Override
//            public void destroy() {
//
//            }
//        };
//    }
}
