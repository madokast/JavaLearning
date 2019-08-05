package M04_HTTP_And_Response;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * servlet 默认地址？
 *  D:\Program Files\apache-tomcat-8.5.43\bin
 *
 */

@WebServlet("/outputStreamServlet")
public class OutputStreamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("image/jpg");

        System.out.println(new File(".").getCanonicalPath());
//        OutputStreamWriter.class.getClassLoader().

        final ServletOutputStream outputStream = resp.getOutputStream();
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(
                        new File("D:\\Documents\\GitHub\\JavaLearning\\new\\201908\\web\\img\\java.jpg")));
        final byte[] bytes = bufferedInputStream.readAllBytes();

        outputStream.write(bytes);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
