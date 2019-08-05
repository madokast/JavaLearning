package M04_HTTP_And_Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出字符数据
 *
 * 中文乱码问题
 *      原因：编码和解码作用的字符集不一致
 *      默认字符集为操作系统默认字符集 gbk
 *
 *      1.设置好流的编码
 *      2.告诉浏览器编码方式
 *
 * resp.setContentType("text/html;charset=UTF-8");
 * Content-Type: text/html;charset=UTF-8
 *
 * writer.write("热更新测试，中文测试");
 * <h1>/writeServlet</h1>hello, servlet
 * 热更新测试，中文测试
 */

@WebServlet("/writeServlet")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取流之前
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

//        resp.setCharacterEncoding("UTF-8");
        System.out.println("/writeServlet");
        final PrintWriter writer = resp.getWriter();

        writer.write("<h1>/writeServlet</h1>");
        writer.write("hello, servlet\n");
        writer.write("热更新测试，中文测试");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
