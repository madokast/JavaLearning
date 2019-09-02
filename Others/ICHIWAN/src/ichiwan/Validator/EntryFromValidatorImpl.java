package ichiwan.Validator;

import ichiwan.domain.EntryForm;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//    private int id;
//    private Date dateDone;
//    private String name;
//    private int lengthMinute;
//    private String describing;

public class EntryFromValidatorImpl implements EntryFromValidator {
    @Override
    public List<String> validate(EntryForm entryForm) {
        List<String> errors = new ArrayList<>();

        //    private int id; 略过

        //    private Date dateDone;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(entryForm.getDateDone());
        }catch (ParseException e){
//            e.getErrorOffset();
            errors.add("时间("+entryForm.getDateDone()+")格式错误");
        }

        //    private String name;
        if(entryForm.getName()== null || entryForm.getName().length()==0){
            errors.add("输入项目不能为空");
        }

        //    private int lengthMinute;
        try {
            int lengthMinute = Integer.valueOf(entryForm.getLengthMinute());
            if(lengthMinute<=0){
                errors.add("时长("+entryForm.getLengthMinute()+")必须为正整数");
            }
        }catch (NumberFormatException e){
//            e.printStackTrace();
            errors.add("时长("+entryForm.getLengthMinute()+")必须为整数");
        }

        //    private String describing; 无需验证

        if(errors.size()>0){
            errors.add("项目添加失败");
        }

        return errors;
    }
}
