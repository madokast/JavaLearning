package M05_Cookie_Session_And_JSP;

import Tools.CAPTCHAGenerate;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CAPTCHAServlet0807")
public class CAPTCHAServlet0807 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //拿到发送来的用户填写的验证码
        final String value = request.getParameter("value");
        final HttpSession session = request.getSession();
        final Object captchaServlet0807Session = session.getAttribute("CAPTCHAServlet0807");
        if(value!=null&&captchaServlet0807Session!=null){
            response.setContentType("text/html");
            if(value.equalsIgnoreCase(captchaServlet0807Session.toString())){
                //验证码输入正确
                response.getWriter().write("OK");
            }else{
                //输入错误
                response.getWriter().write("ERROR");
            }

        }else{
            final String form = "png";
            //验证码图片
            response.setContentType("image/"+form);
            final CAPTCHAGenerate captchaGenerate = new CAPTCHAGenerate(200,50);
            final CAPTCHAGenerate.ImgAndInfo captcha = captchaGenerate.getCAPTCHA();

            session.setAttribute("CAPTCHAServlet0807",captcha.getInfo());

            ImageIO.write(captcha.getImg(),form,response.getOutputStream());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
