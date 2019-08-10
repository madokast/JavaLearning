package M05_Cookie_Session_And_JSP;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 739
 * 记录上次访问时间的小测试
 *
 * 这个视频里写的代码有点难读啊
 */

@WebServlet("/timeRecordCookieServlet")
public class TimeRecordCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TimeRecordCookieServlet");
        response.setContentType("text/html;charset=utf-8");
        final PrintWriter writer = response.getWriter();

        final Cookie[] cookies = request.getCookies();
        Cookie timeRecordCookie = null;

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("TimeRecordCookie")) {
                    timeRecordCookie = cookie;
                }
            }
        }

        final long currentTimeMillis = System.currentTimeMillis();

        if (timeRecordCookie == null) {
            writer.write("欢迎新用户~~");
            timeRecordCookie = new Cookie("TimeRecordCookie", String.valueOf(currentTimeMillis));
        } else {
            writer.write("欢迎回来<br>");
            writer.write("您上次到访时间是：" + new Date(currentTimeMillis).toString());
            timeRecordCookie.setValue(String.valueOf(currentTimeMillis));
        }

//        timeRecordCookie.setMaxAge(10);
        response.addCookie(timeRecordCookie);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
