package ichiwan.web.servlet.web;

import ichiwan.web.servlet.utils.ServletUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 接受全部的表单请求
 * 根据内容派发
 */

@WebServlet("/handOutServlet")
public class HandOutServlet extends HttpServlet {
    private SimpleDateFormat dateFormatYYYYMMDD = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dateFormatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("handOutServlet");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //设置today attribute
        request.setAttribute("today",dateFormatYYYYMMDD.format(new Date()));

        //分发
        ServletUtils.dispatchAsParameterInProperties(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
