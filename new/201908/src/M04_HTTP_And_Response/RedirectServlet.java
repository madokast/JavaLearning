package M04_HTTP_And_Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Repeatable;

/**
 * 完成重定向
 * 请求转发和重定向的区别，浏览器是否知晓
 * <p>
 * 重定向方法
 * 告诉浏览器需要重定向 302 状态码
 * 告诉浏览器新的地址
 *
 * 重定向特点：
 *      地址栏变化
 *      可以访问外部资源
 *      发送两次请求
 *
 * 转发特点：地址栏目路径不变 只能访问当球服务器下的资源 只发送请求一次
 *
 * 路径写法
 *      1. 路径分类。相对路径，绝对路径。
 *          绝对路径：唯一资源  http://。。。
 *          服务器的绝对路径： /201908_war_exploded/redirectToServlet
 *          相对路径：不能确定唯一资源  /redirectToServlet
 *              需要确定当前访问的资源和目标资源的相对关系<a href="/201908_war_exploded/location.html"></a>
 *              !!不推荐使用，因为从事确定来确定去很麻烦
 *
 *          绝对路径的写法：
 *              以 / 开头
 *              判断要定义的路径是给谁用的？
 *                      给客户端/浏览器用——需要虚拟目录 /201908_war_exploded。。
 *                      给服务器用——不需要虚拟目录 context  /。。。
 *               tql!!!
 *               虚拟目录不要写死了，使用动态获取虚拟目录
 *
 *               以后虚拟目录一定动态获取，用于重定向，<a></>标签，反正只要是给浏览器看的，就使用虚拟目录+资源
 *               而且一定要使用动态方法获取，不能写死了
 *
 */

@WebServlet("/redirectServlet")//给服务器看的绝对路径
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("redirectServlet");

        //动态获取虚拟目录
        final String contextPath = request.getContextPath();

        //原始方法
        if (false) {
            //重定向状态码
            response.setStatus(302);
            //设置重定向位置
            response.setHeader("location", "/201908_war_exploded/redirectToServlet");
            //给浏览器看的绝对路径
        }


        //重定向以后用到非常多
        //所以有简单的方法
        //新方法
        if(true){
            System.out.println("contextPath = " + contextPath);
            System.out.println("sendRedirect");
            response.sendRedirect(contextPath+"/redirectToServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
