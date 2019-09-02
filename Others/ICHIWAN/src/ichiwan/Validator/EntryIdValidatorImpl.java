package ichiwan.Validator;

import ichiwan.service.EntryService;
import ichiwan.service.EntryServiceImpl;
import ichiwan.service.EntryTailService;
import ichiwan.service.EntryTailServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class EntryIdValidatorImpl implements EntryIdValidator{
    @Override
    public List<String> validate(String id) {
        List<String> errors = new ArrayList<>();

        try{
            final int idNumber = Integer.parseInt(id);
            if(idNumber<=0){
                errors.add("编号("+id+")应大于0");
            }
            EntryService entryService = new EntryServiceImpl();
            final int maxId = entryService.EntryNumber();
            if(idNumber> maxId){
                errors.add("编号("+id+")应小于等于"+maxId);
            }

        }catch (NumberFormatException e){
            errors.add("编号("+id+")不是数字");
        }

        return errors;
    }
}
