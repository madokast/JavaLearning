package ichiwan.web.servlet.deprecatedServlet;

import ichiwan.Validator.ErrorsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

//        final List<String> errors = ErrorsUtils.initializeErrors();
//        ErrorsUtils.putError(errors,"暂不支持SelectUserServlet");
//        ErrorsUtils.requestAddErrorAttribute(request,errors);

        request.getRequestDispatcher("/findUserByPageServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
