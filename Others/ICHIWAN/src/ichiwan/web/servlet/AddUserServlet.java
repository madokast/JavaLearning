package ichiwan.web.servlet;

import ichiwan.Validator.EntryFromValidator;
import ichiwan.Validator.EntryFromValidatorImpl;
import ichiwan.domain.EntryForm;
import ichiwan.service.EntryService;
import ichiwan.service.EntryServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * 1. 设置编码
 * 2. 获取所有数据
 * 3. 封装对象
 * 4. 调用service完成保存
 * 5. 跳转到 /enterServlet 再次查询并显示
 *
 * UserService
 * public void add(User user){dao.add}
 *
 * UserDao
 * public void add(User user){数据库}
 */

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //重要，这样才能读中文
        request.setCharacterEncoding("UTF-8");

        //打印一下
        System.out.println("/addUserServlet");
        request.getParameterMap().entrySet().forEach(e->{
            for (int i = 0; i < e.getValue().length; i++) {
                System.out.println(e.getKey()+"="+e.getValue()[i]);
            }
        });

        //开始业务
        //获取参数
        final Map<String, String[]> map = request.getParameterMap();
        //封装对象
        EntryForm entryForm = new EntryForm();
        try {
            BeanUtils.populate(entryForm,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //检查EntryForm是否正确
        EntryFromValidator entryFromValidator = new EntryFromValidatorImpl();
        final List<String> errors = entryFromValidator.validate(entryForm);
        request.setAttribute("errors",errors);

        if(errors.size()==0){
            //没有错误
            //调用service保存
            EntryService entryService = new EntryServiceImpl();
            entryService.addEntry(entryForm);
            errors.add("添加成功!");
        }

        //跳转到enterServlet
        request.getRequestDispatcher("/enterServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
