package ichiwan.Validator;

import ichiwan.domain.EntryForm;

import java.util.List;

public interface EntryPageValidator {
    List<String> validate(String page);
}
