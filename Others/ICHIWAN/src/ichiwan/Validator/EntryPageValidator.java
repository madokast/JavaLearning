package ichiwan.Validator;

import ichiwan.domain.EntryForm;

import java.util.List;

public interface EntryPageValidator {
    @Deprecated
    List<String> validate(String page);
}
