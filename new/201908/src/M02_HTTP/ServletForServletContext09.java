package M02_HTTP;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo009")
public class ServletForServletContext09 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final ServletContext servletContext = req.getServletContext();
        System.out.println("servletContext = " + servletContext);
        System.out.println("demo009拿到了servlet context对象，还不知道有什么用...");
    }
}
