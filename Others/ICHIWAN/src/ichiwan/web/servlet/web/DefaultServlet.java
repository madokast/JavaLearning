package ichiwan.web.servlet.web;

import ichiwan.Validator.ErrorsUtils;
import ichiwan.Validator.PageBeanFormValidator;
import ichiwan.Validator.PageBeanFormValidatorImpl;
import ichiwan.domain.EntryTail;
import ichiwan.domain.PageBean;
import ichiwan.domain.PageBeanForm;
import ichiwan.service.EntryService;
import ichiwan.service.EntryServiceImpl;
import ichiwan.web.servlet.utils.ServletUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet("/defaultServlet")
public class DefaultServlet extends HttpServlet {
    //# 默认页数为首页
    //currentPage=1
    //# 默认每页显示10条记录
    //rows=10
    private Properties iChiWanProperties = null;

    private EntryService entryService = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //这个必须有。查找了多年的错误啊
        //2019年9月3日
        super.init(config);

        final ServletContext servletContext = this.getServletContext();
        final String realPath = servletContext.getRealPath("/WEB-INF/classes/ichiwan.properties");
        iChiWanProperties = new Properties();
        try {
            iChiWanProperties.load(new FileInputStream(realPath));
            System.out.println("/DefaultServlet 初始化成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        entryService = new EntryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/defaultServlet");

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //通过iChiWanProperties制作默认的PageBeanForm
        PageBeanForm pageBeanForm = new PageBeanForm();
        //    private String rows;
        //    private String currentPage;
        try {
            BeanUtils.populate(pageBeanForm, iChiWanProperties);
        } catch (Exception e) {
            ErrorsUtils.addErrorToErrors(request, "error in DefaultServlet in " +
                    "BeanUtils.populate(pageBeanForm,iChiWanProperties);");
        }

        //校验。可能不是很必要
        PageBeanFormValidator pageBeanFormValidator = new PageBeanFormValidatorImpl();
        final List<String> errors = pageBeanFormValidator.validate(pageBeanForm);
        if (errors.size() == 0) {
            //没有错误
//            EntryTailService entryTailService = new EntryTailServiceImpl();
            final PageBean<EntryTail> pageBean = entryService.findByPageBeanForm(pageBeanForm);
            request.setAttribute("pageBean", pageBean);
        } else {
            //有错误
            ErrorsUtils.addErrorToErrors(request, errors);
            ErrorsUtils.addErrorToErrors(request, "分页查询失败");
        }


//        ErrorsUtils.addErrorToErrors(request,"defaultServlet暂不支持");

        //展示
        ServletUtils.dispatchToViewJSP(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
