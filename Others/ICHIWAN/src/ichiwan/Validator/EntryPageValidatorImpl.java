package ichiwan.Validator;

import ichiwan.util.Tools;

import java.util.ArrayList;
import java.util.List;

public class EntryPageValidatorImpl implements EntryPageValidator {
    @Override
    @Deprecated
    public List<String> validate(String page) {
        Tools.forceExit();

        List<String> errors = new ArrayList<>();
        int pageNumber = 0;
        try{
            pageNumber = Integer.valueOf(page);
            if(pageNumber<1){
                errors.add("页数("+page+")应大于0");
            }
//            EntryTailService entryTailService = new EntryTailServiceImpl();
//            final int pageNumberLimit10 = entryTailService.pageNumberLimit10();
            final int pageNumberLimit10 = 0;
            if(pageNumber> pageNumberLimit10){
                errors.add("页数("+page+")应小于"+pageNumberLimit10);
            }
        }catch (NumberFormatException e){
            errors.add("页数("+page+")应为整数数字");
        }

        return errors;
    }
}
