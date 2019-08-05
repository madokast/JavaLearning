package M04_HTTP_And_Response;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/fileDownloadServlet")
public class FileDownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("fileDownloadServlet");

        final String referer = req.getHeader("Referer");
        System.out.println(referer);

        if(referer!=null&&referer.contains("FileDownload")){
            System.out.println("开始下载");
            final ServletContext servletContext = this.getServletContext();

            final String imgRealPath = servletContext.getRealPath("img/java.jpg");
            final String mimeType = servletContext.getMimeType(imgRealPath);

            resp.setContentType(mimeType);
            resp.setHeader("Content-Disposition","attachment;filename=javaCoffee.jpg");

            final byte[] allBytes = new BufferedInputStream(new FileInputStream(new File(imgRealPath))).readAllBytes();

            resp.getOutputStream().write(allBytes);
        }else{
            resp.getWriter().write("referer error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
