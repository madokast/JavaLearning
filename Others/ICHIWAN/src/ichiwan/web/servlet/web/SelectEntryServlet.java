package ichiwan.web.servlet.web;

import ichiwan.Validator.ErrorsUtils;
import ichiwan.web.servlet.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectEntryServlet")
public class SelectEntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");


        ErrorsUtils.addErrorToErrors(request,"selectEntryServlet暂不支持");

        //丢给默认servlet
        ServletUtils.dispatchDefaultServlet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
