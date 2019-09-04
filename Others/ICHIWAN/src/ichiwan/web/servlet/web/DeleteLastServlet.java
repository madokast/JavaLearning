package ichiwan.web.servlet.web;

import ichiwan.Validator.ErrorsUtils;
import ichiwan.service.EntryService;
import ichiwan.service.EntryServiceImpl;
import ichiwan.web.servlet.utils.ServletUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteLastServlet")
public class DeleteLastServlet extends HttpServlet {
    private EntryService entryService = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        entryService = new EntryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        final int idLast = entryService.lastId();
        if(idLast==0){
            ErrorsUtils.addErrorToErrors(request,"记录为空，无法删除");
        }else {
            entryService.deleteEntry(idLast);
            ErrorsUtils.addErrorToErrors(request,"删除编号为"+idLast+"的项目成功");
        }


        //跳转到分页查询，最后一页
        request.setAttribute("pageLast","pageLast");
        ServletUtils.dispatch(request,response,ServletUtils.getDispatchServletProperties().getProperty("pageLast"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
