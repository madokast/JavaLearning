package ichiwan.Validator;

import ichiwan.domain.PageBeanForm;

import java.util.List;

public interface PageBeanFormValidator {
    List<String> validate(PageBeanForm pageBeanForm);
}
