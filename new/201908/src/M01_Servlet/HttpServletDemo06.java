package M01_Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet->GenericServlet->Servlet
 * 对heep协议的封装
 *
 * 1.判断请求方式，并判断
 *  method = req.getMethod()
 *      HttpServlet帮你已经读取了请求方式
 *   if(method.equals("get")){
 *       doGet();
 *   }else if(ethod.equals("post")){
 *       doPost();
 *   }.....
 * 2. 综上，只要覆写
 *      doGet();
 *      doPost();
 *      现在只考考虑这两个
 */

@WebServlet("/demo006")
public class HttpServletDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo006-doGet");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo005-doPost");
    }
}
