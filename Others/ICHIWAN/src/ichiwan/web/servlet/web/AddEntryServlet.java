package ichiwan.web.servlet.web;

import ichiwan.Validator.EntryFromValidator;
import ichiwan.Validator.EntryFromValidatorImpl;
import ichiwan.Validator.ErrorsUtils;
import ichiwan.domain.EntryForm;
import ichiwan.domain.EntryTail;
import ichiwan.service.EntryService;
import ichiwan.service.EntryServiceImpl;
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

@WebServlet("/addEntryServlet")
public class AddEntryServlet extends HttpServlet {
    private EntryFromValidator entryFromValidator = null;
    private EntryService entryService = null;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //这东西需要使用多次，不要每次都实例化了
        entryFromValidator = new EntryFromValidatorImpl();
        entryService = new EntryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddEntryServlet");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //拿到EntryForm
        //    private String id;
        //    private String dateDone;
        //    private String name;
        //    private String lengthMinute;
        //    private String describing;
        final Map<String, String[]> map = ServletUtils.getParameterMap(request,
                "id", "dateDone", "name", "lengthMinute", "describing");
        final EntryForm entryForm = new EntryForm();
        try {
            BeanUtils.populate(entryForm,map);
        }catch (Exception e){
            ErrorsUtils.addErrorToErrors(request,"error in addEntryServlet in BeanUtils.populate(entryForm,map); " +
                    "because "+ e.getMessage());
        }

        //验证
        final List<String> errors = entryFromValidator.validate(entryForm);
        ErrorsUtils.addErrorToErrors(request,errors);
        if(errors.size()==0){
            //没问题，可以添加
            entryService.addEntry(entryForm);
            ErrorsUtils.addErrorToErrors(request,"添加成功!编号为 " + entryService.EntryNumber());
        }
        else {
            //有问题
            ErrorsUtils.addErrorToErrors(request,"添加失败!");
        }

        //跳转到分页查询，最后一页
        request.setAttribute("pageLast","pageLast");
        ServletUtils.dispatch(request,response,ServletUtils.getDispatchServletProperties().getProperty("pageLast"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
