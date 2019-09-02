package ichiwan.web.servlet;

import ichiwan.Validator.PageBeanFormValidator;
import ichiwan.Validator.PageBeanFormValidatorImpl;
import ichiwan.domain.EntryTail;
import ichiwan.domain.PageBean;
import ichiwan.domain.PageBeanForm;
import ichiwan.service.EntryTailService;
import ichiwan.service.EntryTailServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //制作pageBeanForm
        final Map<String, String[]> parameterMap = request.getParameterMap();
        final PageBeanForm pageBeanForm = new PageBeanForm();
        try {
            BeanUtils.populate(pageBeanForm, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //验证pageBeanForm
        PageBeanFormValidator pageBeanFormValidator = new PageBeanFormValidatorImpl();
        final List<String> errors = pageBeanFormValidator.validate(pageBeanForm);
        request.setAttribute("errors",errors);

        //查询获得真正的pageBean
        EntryTailService entryTailService = new EntryTailServiceImpl();
        if(errors.size()==0){
            //没有错误
            errors.add("分页查询成功!");
        }
        else{
            //有错误
            errors.add("分页查询存在错误!");
            pageBeanForm.setCurrentPage("1");
            pageBeanForm.setRows("10");
        }

        final PageBean<EntryTail> pageBean = entryTailService.findByPageBeanForm(pageBeanForm);

        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/enterServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
