package ichiwan.web.servlet.web;

import ichiwan.Validator.ErrorsUtils;
import ichiwan.Validator.PageBeanFormValidator;
import ichiwan.Validator.PageBeanFormValidatorImpl;
import ichiwan.domain.EntryTail;
import ichiwan.domain.PageBean;
import ichiwan.domain.PageBeanForm;
import ichiwan.service.EntryService;
import ichiwan.service.EntryServiceImpl;
import ichiwan.util.Tools;
import ichiwan.web.servlet.utils.ServletUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    private EntryService entryService = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        entryService = new EntryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //拿到PageBeanForm的资料
        //    private String rows;
        //    private String currentPage;
        final Map<String, String[]> map = ServletUtils.getParameterMap(request, "rows", "currentPage");
        PageBeanForm pageBeanForm = new PageBeanForm();
        try {
            BeanUtils.populate(pageBeanForm,map);
        }catch (Exception e){
            e.printStackTrace();
            ErrorsUtils.addErrorToErrors(request,"error in PageServlet in BeanUtils.populate(pageBeanForm,map);");
        }

        //校验
        PageBeanFormValidator pageBeanFormValidator = new PageBeanFormValidatorImpl();
        final List<String> errors = pageBeanFormValidator.validate(pageBeanForm);
        ErrorsUtils.addErrorToErrors(request,errors);
        if(!errors.isEmpty()){
            //错误。丢给默认servlet
            ServletUtils.dispatchDefaultServlet(request,response);
            return;
        }

        //查看具体是哪个业务
        if(ServletUtils.hasParameterOrAttribute(request,"pageAll")){
            System.out.println("pageAll");
            pageBeanForm.setRows(request.getParameter("totalCount"));
            pageBeanForm.setCurrentPage("1");
        }else if(ServletUtils.hasParameterOrAttribute(request,"pageLast")){
            System.out.println("pageLast");
            pageBeanForm.setCurrentPage(request.getParameter("totalPage"));
        }else if(ServletUtils.hasParameterOrAttribute(request,"pageNext")){
            System.out.println("pageNext");
            try {
                pageBeanForm.setCurrentPage(Tools.addOnString(pageBeanForm.getCurrentPage(),1));
            }catch (Exception e){ErrorsUtils.addErrorToErrors(request,
                    "error in PageServlet in pageNext because " + e.getMessage());}
        }else if(ServletUtils.hasParameterOrAttribute(request,"pagePrevious")){
            System.out.println("pagePrevious");
            try {
                pageBeanForm.setCurrentPage(Tools.addOnString(pageBeanForm.getCurrentPage(),-1));
            }catch (Exception e){ErrorsUtils.addErrorToErrors(request,
                    "error in PageServlet in pagePrevious because " + e.getMessage());}
        } else if(ServletUtils.hasParameterOrAttribute(request,"pageFirst")){
            System.out.println("pageFirst");
            pageBeanForm.setCurrentPage("1");
        }

        //再次校验
        final List<String> errors2 = pageBeanFormValidator.validate(pageBeanForm);
        ErrorsUtils.addErrorToErrors(request,errors2);
        if(!errors.isEmpty()){
            //错误。丢给默认servlet
            ServletUtils.dispatchDefaultServlet(request,response);
            return;
        }

        //查询
//        EntryTailService entryTailService = new EntryTailServiceImpl();
//        final PageBean<EntryTail> pageBean = entryTailService.findByPageBeanForm(pageBeanForm);
        final PageBean<EntryTail> pageBean = entryService.findByPageBeanForm(pageBeanForm);
        request.setAttribute("pageBean", pageBean);


        //展示
        ServletUtils.dispatchToViewJSP(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
