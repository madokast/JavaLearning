package ichiwan.web.servlet.deprecatedServlet;

import ichiwan.Validator.EntryIdValidator;
import ichiwan.Validator.EntryIdValidatorImpl;
import ichiwan.domain.Entry;
import ichiwan.service.EntryService;
import ichiwan.service.EntryServiceImpl;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 删除Entry 的servlet
 */

@WebServlet("/deleteEntryServlet")
public class DeleteEntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("/deleteEntryServlet");
        final String id = request.getParameter("id");
        System.out.println("id = " + id);

        EntryIdValidator entryIdValidator = new EntryIdValidatorImpl();
        final List<String> errors = entryIdValidator.validate(id);


        if(errors.size()==0){
            final Integer idNumber = Integer.valueOf(id);
            //没有错误
            EntryService entryService = new EntryServiceImpl();
            Entry deleteEntry = null;
            try {
                deleteEntry  = entryService.queryEntryById(idNumber);
                entryService.deleteEntry(idNumber);
                errors.add(deleteEntry.toString()+" 删除成功!");
            }catch (NumberFormatException e){e.printStackTrace();}
        }
        else {
            errors.add("删除失败");
        }

        request.setAttribute("errors",errors);
        request.getRequestDispatcher("findUserByPageServlet").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
