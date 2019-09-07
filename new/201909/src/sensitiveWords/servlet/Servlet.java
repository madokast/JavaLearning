package sensitiveWords.servlet;

import sensitiveWords.Word;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/word/servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("/word/servlet");

        final String[] newBody = (String[])request.getAttribute("newBody");
        final Word word = new Word(new Date(), newBody[0]);

        final Object list = this.getServletContext().getAttribute("list");
        if(list==null){
            final ArrayList<Word> words = new ArrayList<>();
            words.add(word);
            this.getServletContext().setAttribute("list",words);
        }else {
            ArrayList<Word> words = (ArrayList<Word>)list;
            words.add(word);
        }


        request.getRequestDispatcher("/word/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
