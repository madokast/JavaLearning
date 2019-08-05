package M04_HTTP_And_Response;


import Tools.CAPTCHAGenerate;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * 验证码 CAPTCHA
 * 干扰线
 */

@WebServlet("/CAPTCHAServlet")
public class CAPTCHASServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CAPTCHAServlet");
        int width = 100;
        int height = 50;
        String imgType = "png";


        resp.setContentType("image/"+imgType);
        final ServletOutputStream outputStream = resp.getOutputStream();
        final CAPTCHAGenerate.ImgAndInfo captcha = new CAPTCHAGenerate(200, 100).getCAPTCHA();

        final String captchaInfo = captcha.getInfo();
        System.out.println("验证码是"+captchaInfo);

        ImageIO.write(
                captcha.getImg(),
                imgType,
                outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
