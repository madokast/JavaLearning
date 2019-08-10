package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/bigWorkCookieServlet")
public class BigWorkCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BigWorkCookieServlet");

        resp.setContentType("text/html;charset=utf-8");

        final Cookie[] cookies = req.getCookies();

        final PrintWriter writer = resp.getWriter();

        for (int i = 0; i < cookies.length; i++) {
            writer.write(cookies[i].toString()+"<br>");
            writer.write(cookies[i].getName()+"<br>");
            writer.write(URLDecoder.decode(cookies[i].getValue(),"UTF-8") +"<br>");
            writer.write("---------------"+"<br>");
        }

        System.out.println("读取所有cookie完毕");
    }
}
