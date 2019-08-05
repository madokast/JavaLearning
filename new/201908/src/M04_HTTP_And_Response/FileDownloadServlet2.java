package M04_HTTP_And_Response;

import util.DownloadUtils;

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
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 中文文件名问题!!
 * 我都遇见过很多次啊
 * 这怎么办呢？
 */

@WebServlet("/fileDownloadServlet2")
public class FileDownloadServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("fileDownloadServlet2");

        final ServletContext servletContext = this.getServletContext();


        //文件名
        final String filename = req.getParameter("filename");
        System.out.println("filename = " + filename);



        //realpath
        final String realPath = servletContext.getRealPath("img/"+ filename);
        final File file = new File(realPath);
        System.out.println(file.exists());

        //文件类型
        final String mimeType = servletContext.getMimeType(realPath);
        resp.setContentType(mimeType);
        //附件形式
        final String userAgent = req.getHeader("User-Agent");


        resp.setHeader("content-disposition","attachment;filename="+ DownloadUtils.getFilename(
                req.getHeader("User-Agent"),filename
        ));
        resp.setCharacterEncoding("UTF-8");//这个编码只是用于消息体的

        System.out.println("userAgent = " + userAgent);

        //stream
        final byte[] bytes = new BufferedInputStream(new FileInputStream(file)).readAllBytes();
        resp.getOutputStream().write(bytes);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
