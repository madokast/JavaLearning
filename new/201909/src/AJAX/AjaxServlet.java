package AJAX;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/JQuery/ajaxServlet")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        System.out.println("/ajaxServlet");
        System.out.println(Thread.currentThread().getName());

        if(request.getParameter("username").equals("tom")){

            try {
                Thread.currentThread().sleep(5000);
            }catch ( Exception e){
                e.printStackTrace();
            }

            final String username = request.getParameter("username");
            System.out.println("username = " + username);

            response.getWriter().print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            return;
        }

        if(request.getParameter("username").equals("jack")){
            response.getWriter().print(Math.random());

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
