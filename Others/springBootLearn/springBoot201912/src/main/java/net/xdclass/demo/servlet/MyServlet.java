package net.xdclass.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description
 * 自己写servlet
 * <p>
 * Data
 * 2019/12/18 20:54
 *
 * @author zrx
 * @version 1.0
 */

@WebServlet(name = "myservlet" ,urlPatterns = "/myservlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type","application/json");

        final PrintWriter writer = resp.getWriter();
        writer.write("{\"MyServlet\":\"原生servlet\"}");

        writer.flush();

        writer.close();
    }
}
