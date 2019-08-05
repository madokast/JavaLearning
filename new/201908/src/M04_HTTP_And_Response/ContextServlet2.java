package M04_HTTP_And_Response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextServlet2")
public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("contextServlet2");

        resp.setContentType("text/html;charset=utf-8");

        final ServletContext servletContext = this.getServletContext();

        String key = "contextServlet0805";

        final Object contextServlet0805 = servletContext.getAttribute(key);
        servletContext.removeAttribute(key);

        resp.getWriter().write("contextServlet2 查看 "+key +",找到了——<br>");
        resp.getWriter().write(contextServlet0805.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
