package AJAX;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/servlet01Y")
public class Servlet01Y extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        System.out.println("/servlet01Y 开始处理(" + Thread.currentThread().getName() + ")" + new Date());

        System.out.println(request.getParameter("a"));
        try {
            Thread.sleep(5000); }
        catch (Exception e) { e.printStackTrace(); }


        System.out.println("/servlet01Y 处理结束(" + Thread.currentThread().getName() + ")" + new Date());
        System.out.println("------------------------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
