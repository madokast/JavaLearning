package ichiwan.Validator;

import ichiwan.domain.EntryForm;

import java.util.List;

/**
 * 校验器
 */

public interface EntryFromValidator {
    List<String> validate(EntryForm entryForm);
}
