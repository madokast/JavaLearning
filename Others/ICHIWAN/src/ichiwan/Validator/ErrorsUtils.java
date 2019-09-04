package ichiwan.Validator;

import java.util.ArrayList;
import java.util.List;

public class ErrorsUtils {
    /**
     * 完美!! 在request中添加Attribute-[errors]，
     * errors是一个List<String>，包含所有的(String)error信息
     * <p>
     * 是个好方法。若errors不存在，则创建并添加，若存在，则直接添加
     *
     * @param request javax.servlet.http.HttpServletRequest
     * @param error   字符串的错误信息，将显示在HTML上
     */
    public static void addErrorToErrors(javax.servlet.http.HttpServletRequest request, String error) {
        //拿到Attribute-[errors]
        final Object errorsObj = request.getAttribute("errors");
        if (errorsObj == null) {
            //不存在这个Attribute-[errors]
            //创建并添加
            final List<String> errors = initializeErrors();
            request.setAttribute("errors", errors);
            putError(errors, error);
        } else {
            //存在Attribute-[errors]
            //直接添加
            ((List<String>) errorsObj).add(error);
        }

    }

    /**
     * see addErrorToErrors(r, Str)
     *
     * @param request javax.servlet.http.HttpServletRequest
     * @param errors  字符串List的错误信息，将显示在HTML上
     */
    public static void addErrorToErrors(javax.servlet.http.HttpServletRequest request, List<String> errors) {
        //拿到Attribute-[errors]
        final Object errorsObj = request.getAttribute("errors");
        if (errorsObj == null) {
            //不存在这个Attribute-[errors]
            //设置之
            request.setAttribute("errors", errors);

        } else {
            //存在Attribute-[errors]
            //直接添加
            ((List<String>) errorsObj).addAll(errors);
        }
    }

    private static List<String> initializeErrors() {
        return new ArrayList<String>();
    }

    private static List<String> putError(List<String> errors, String error) {
        errors.add(error);
        return errors;
    }

    private static void requestAddErrorAttribute(javax.servlet.http.HttpServletRequest request, List<String> errors) {
        final Object errorsObj = request.getAttribute("errors");
        if (errorsObj == null) {
            request.setAttribute("errors", errors);
        } else {
            ((List<String>) errorsObj).addAll(errors);
        }
    }
}
