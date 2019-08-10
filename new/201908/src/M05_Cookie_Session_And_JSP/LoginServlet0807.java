package M05_Cookie_Session_And_JSP;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/LoginServlet0807")
public class LoginServlet0807 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final HashMap<String, String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);

        final UserDao userDao = new UserDao();
        try {
            final User user = new User();
            BeanUtils.populate(user, map);
            final User login = userDao.login(user);
            if(login==null){
                throw new Exception("用户名或密码错误");
            }else {
                //登陆成功
                response.getWriter().write("登陆成功");
            }
        }catch (Exception e){
//            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
