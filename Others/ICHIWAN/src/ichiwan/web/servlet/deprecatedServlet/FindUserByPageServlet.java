package ichiwan.web.servlet.deprecatedServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

//        //制作pageBeanForm
//        final Map<String, String[]> parameterMap = new HashMap<>();
//
//        parameterMap.put("rows",request.getParameterValues("rows"));
//        parameterMap.put("currentPage",request.getParameterValues("currentPage"));
////        Tools.printMapStrStrs(parameterMap);
//        PageBeanForm pageBeanForm = new PageBeanForm();
//        try {
//            BeanUtils.populate(pageBeanForm, parameterMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //验证pageBeanForm
//        PageBeanFormValidator pageBeanFormValidator = new PageBeanFormValidatorImpl();
//        final List<String> errors = pageBeanFormValidator.validate(pageBeanForm);
//        ErrorsUtils.requestAddErrorAttribute(request,
//                pageBeanFormValidator.validate(pageBeanForm));
//
//
//        //查询获得真正的pageBean
//        EntryTailService entryTailService = new EntryTailServiceImpl();
//        if(errors.size()==0){
//            //没有错误
////            errors.add("分页查询成功!");
//        }
//        else{
//            //有错误
//            errors.add("分页查询存在错误!显示默认");
//            pageBeanForm = entryTailService.getDefaultPageBeanForm();
//        }
//
//        final PageBean<EntryTail> pageBean = entryTailService.findByPageBeanForm(pageBeanForm);
//
//        request.setAttribute("pageBean",pageBean);
//        request.setAttribute("today",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        request.getRequestDispatcher("/ichiwan.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
