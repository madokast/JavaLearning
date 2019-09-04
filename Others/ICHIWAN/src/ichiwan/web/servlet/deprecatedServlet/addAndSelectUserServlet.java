package ichiwan.web.servlet.deprecatedServlet;

import ichiwan.Validator.ErrorsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addAndSelectUserServlet")
public class addAndSelectUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

//        if(request.getParameter("addEntry")!=null){
//            System.out.println("从addAndSelectUserServlet进入addUserServlet");
//            request.getRequestDispatcher("/addUserServlet").forward(request,response);
//        }
//        else if(request.getParameter("selectEntry")!=null){
//            System.out.println("从addAndSelectUserServlet进入selectEntry");
//            request.getRequestDispatcher("/SelectUserServlet").forward(request,response);
//        }
//        else {
//            final List<String> errors = ErrorsUtils.initializeErrors();
//            ErrorsUtils.putError(errors,"addAndSelectUserServlet发生错误");
//            ErrorsUtils.requestAddErrorAttribute(request,errors);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
