package AJAX;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/servlet01X")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        System.out.println("/servlet01X 开始处理(" + Thread.currentThread().getName()+")"+new Date());
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        }catch (Exception e){e.printStackTrace();}

        System.out.println("/servlet01X 处理结束(" + Thread.currentThread().getName()+")"+new Date());
        System.out.println("------------------------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
