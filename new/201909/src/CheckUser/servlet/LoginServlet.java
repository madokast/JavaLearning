package CheckUser.servlet;

import CheckUser.domain.DefaultUser;
import CheckUser.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/user/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");


        final Object sessionUser = request.getSession().getAttribute("user");

        if(sessionUser!=null&&sessionUser.equals(DefaultUser.getDefaultUser())){
            List<String> errors = (List<String>)request.getAttribute("errors");
            if(errors==null){
                errors = new ArrayList<>();
                request.setAttribute("errors",errors);
            }
            errors.add("您已登陆");

            request.getRequestDispatcher("/user/welcome.jsp").forward(request,response);
        }else {
            final Map<String, String[]> parameterMap = request.getParameterMap();
            for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
                System.out.println(stringEntry.getKey()+":"+stringEntry.getValue()[0]);
            }
            final User user = new User();
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            request.getSession().setAttribute("user",user);

            if(user.equals(DefaultUser.getDefaultUser())){
                //登陆成功
                List<String> errors = (List<String>)request.getAttribute("errors");
                if(errors==null){
                    errors = new ArrayList<>();
                    request.setAttribute("errors",errors);
                }
                errors.add("登陆成功");

                request.getRequestDispatcher("/user/welcome.jsp").forward(request,response);
            }else {
                //登陆失败
                List<String> errors = (List<String>)request.getAttribute("errors");
                if(errors==null){
                    errors = new ArrayList<>();
                    request.setAttribute("errors",errors);
                }
                errors.add("用户名或密码错误，请重新登陆");

                request.getRequestDispatcher("/user/login.jsp").forward(request,response);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
