package zrx.com.leetcode.utils.LeerCodeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Description
 * 答案
 * <p>
 * Data
 * 2019/11/10 15:44
 *
 * @author zrx
 * @version 1.0
 */

public class Answer {
    private Value value;

    private Answer(Value value) {
        this.value = value;
    }

    public static List<Answer> makeAnswerList(Class clazz,Object...answers){
        Answer[] answerArr = new Answer[answers.length];
        for (int i = 0; i < answerArr.length; i++) {
            answerArr[i] = getInstance(clazz,answers[i]);
        }

        return makeAnswerList(answerArr);
    }

    public static List<Answer> makeAnswerList(Object...answers){
        Objects.requireNonNull(answers);
        return makeAnswerList(answers[0].getClass(),answers);
    }

    static List<Answer> makeAnswerList(Answer...answers){
        List<Answer> list = new ArrayList<>(answers.length);
        for (int i = 0; i < answers.length; i++) {
            list.add(i,answers[i]);
        }

        return list;
    }

    static Answer getInstance(Class clazz,Object val){
        return new Answer(Value.newInstance(clazz,val));
    }

    public Class getClazz() {
        return value.getClazz();
    }

    public Object getValue() {
        return value.getValue();
    }
}
