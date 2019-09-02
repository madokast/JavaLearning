package ichiwan.Validator;

import ichiwan.domain.PageBeanForm;
import ichiwan.service.EntryTailService;
import ichiwan.service.EntryTailServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * PageBeanForm校验器
 */

public class PageBeanFormValidatorImpl implements PageBeanFormValidator {
    @Override
    public List<String> validate(PageBeanForm pageBeanForm) {
        final List<String> errors = new ArrayList<>();

        boolean rowsOK = true;

//        private String rows;
        final String rows = pageBeanForm.getRows();
        int rowsNumber = 0;
        try {
            rowsNumber = Integer.parseInt(rows);
            if(rowsNumber<=0){
                rowsOK=false;
                errors.add("每页显示条数("+rowsNumber+")不能为0或负数");
            }
        }catch (NumberFormatException e){
            rowsOK=false;
            errors.add("每页显示条数("+rowsNumber+")应为整数");
        }

//        private String currentPage;
        final String currentPage = pageBeanForm.getCurrentPage();
        int currentPageNumber = 0;
        try {
            currentPageNumber  = Integer.valueOf(currentPage);
            if(currentPageNumber<=0){
                errors.add("当前页数("+currentPageNumber+")不能为0或负数");
            }

            if(rowsOK){
                EntryTailService entryTailService = new EntryTailServiceImpl();
                final int pageNumberLimit = entryTailService.pageNumberLimit(rowsNumber);

                if(currentPageNumber>pageNumberLimit){
                    errors.add("当前页数("+currentPageNumber+")不能超过总页数"+pageNumberLimit);
                }
            }

        }catch (NumberFormatException e){
            errors.add("当前页数("+currentPage+")应为整数");
        }

        return errors;
    }
}
