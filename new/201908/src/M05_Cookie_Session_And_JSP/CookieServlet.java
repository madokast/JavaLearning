package M05_Cookie_Session_And_JSP;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * 生成并发送cookie
 */

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("cookieServlet");

        resp.setContentType("text/html;charset=utf-8");

        String cookieValue = ""+System.currentTimeMillis();
        resp.getWriter().write(cookieValue);

//        final Cookie cookie = new Cookie("myCookie", cookieValue);
        final Cookie cookie = new Cookie("myCookie", URLEncoder.encode("中文测试","utf-8"));

        //設置cookie存活時間
        cookie.setMaxAge(-1);
        cookie.setPath(req.getContextPath());//服务器根目录？
        //-1 默認值。關閉即刪除
        //30--將cookie持久化到硬盤，30秒后自動刪除

        System.out.println("req.getContextPath() = " + req.getContextPath());

        resp.addCookie(cookie);
        System.out.println("cookie已发送");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
