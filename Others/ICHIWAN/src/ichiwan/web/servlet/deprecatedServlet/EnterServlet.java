package ichiwan.web.servlet.deprecatedServlet;

import ichiwan.domain.EntryTail;
import ichiwan.domain.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/enterServlet")
public class EnterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean<EntryTail> pageBean = (PageBean<EntryTail>)req.getAttribute("pageBean");


        req.setAttribute("currentPage",pageBean.getCurrentPage());
        req.setAttribute("totalCount",pageBean.getTotalCount());
        req.setAttribute("totalPage",pageBean.getTotalPage());
//        req.setAttribute("errors",errors);
        req.setAttribute("entryTails", pageBean.getList());
        req.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        req.setAttribute("lastId", pageBean.getTotalCount());

        req.getRequestDispatcher("/ichiwan.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
