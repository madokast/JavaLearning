package AJAX.Servlet01;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ajax/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        final String username = request.getParameter("username");
        boolean userExist;
        String msg;

        if("zrx".equals(username)){
            userExist = true;
            msg = "用户名已存在";
        }else {
            userExist = false;
            msg = "用户名可用";
        }

        Map<String,Object> map = new HashMap<>();
        map.put("userExist",userExist);
        map.put("msg",msg);

        ObjectMapper mapper = new ObjectMapper();
        final String s = mapper.writeValueAsString(map);

        response.getWriter().write(s);

        System.out.println(username);
        System.out.println(s);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
