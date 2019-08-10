package M05_Cookie_Session_And_JSP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionServlet2")
public class SessionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sessionServlet2");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("sessionServlet2"+"<br>");

        final HttpSession session = request.getSession();
        final Object mySession0806 = session.getAttribute("mySession0806");

        response.getWriter().write("拿到了session"+"<br>");
        response.getWriter().write(session+"<br>");
        response.getWriter().write(mySession0806+"<br>");
        response.getWriter().write(session.getId()+"<br>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
