package M05_Cookie_Session_And_JSP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sessionServlet");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("sessionServlet"+"<br>");

        final HttpSession session = request.getSession();
        session.setAttribute("mySession0806","hello, session");
        response.getWriter().write("设置好了session"+"<br>");
        response.getWriter().write(session+"<br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
