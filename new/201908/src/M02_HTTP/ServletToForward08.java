package M02_HTTP;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/demo008")
public class ServletToForward08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是ServletToForward-demo008，准备转发请求");

        System.out.println("demo008打算发一些数据给forward01。请用time获取");
        req.setAttribute("time",System.currentTimeMillis());

        final RequestDispatcher forward01 = req.getRequestDispatcher("/forward01");
        forward01.forward(req,resp);
        System.out.println("-----请求转发完毕------");

        //我是ServletToForward-demo008，准备转发请求
        //demo008打算发一些数据给forward01。请用time获取
        //这里是ServletForward-forward01，似乎拿到了转发，被唤起
        //只有demo08才能给我发消息，让我看看time
        //req.getAttribute("time") = 1564822485288
        //原来它给我发了时间，我看看我的时间1564822485293
        //------合作愉快----
        //-----请求转发完毕------
    }
}
