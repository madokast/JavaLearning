package wordNew;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/wordNew/servlet")
public class Servlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("words",new ArrayList<Word>());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("/wordNew/servlet");

        final String body = request.getParameter("body");
        final Word word = new Word();
        word.setBody(body);
        word.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        final ServletContext servletContext = this.getServletContext();
        final List<Word> words = (List<Word>)servletContext.getAttribute("words");
        words.add(word);

        //展示
        request.getRequestDispatcher("/wordNew/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
