package M03_Review;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet013")
public class SuccessServlet013 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/successServlet013");
        System.out.println("request.getHeader(\"referer\") = " + request.getHeader("referer"));
        if(!request.getHeader("referer").contains("loginTestForDemo010.html")){
            System.out.println("SuccessServlet013--referer出错");
            request.getRequestDispatcher("/loginServlet011").forward(request,response);
        }
        else{
            User user = (User) request.getAttribute("user");
            if(user!=null){
                System.out.println("SuccessServlet013--发送登陆成功信息");
                //设置编码
                response.setContentType("text/html;charset=utf-8");
                //登陆失败
                response.getWriter().write("登陆成功"+user.getUsername()+"欢迎您");
            }
            else {
                System.out.println("SuccessServlet013--user为空，出错");
                request.getRequestDispatcher("/loginServlet011").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
