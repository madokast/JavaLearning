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
import java.security.UnrecoverableEntryException;

@WebServlet("/statisticsServlet")
public class StatisticsServlet extends HttpServlet {
//    private EntryTailService entryTailService = null;
    private EntryService entryService = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        entryTailService = new EntryTailServiceImpl();
        entryService = new EntryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        ErrorsUtils.addErrorToErrors(request,"暂不支持统计");


        //跳转到分页查询，查询全部
        request.setAttribute("pageAll","pageAll");
        ServletUtils.dispatch(request,response,ServletUtils.getDispatchServletProperties().getProperty("pageAll"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
