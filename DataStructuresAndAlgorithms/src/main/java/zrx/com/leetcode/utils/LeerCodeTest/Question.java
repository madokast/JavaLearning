package zrx.com.leetcode.utils.LeerCodeTest;

import java.util.List;

/**
 * 所有leetcode题目实现这个接口
 * 并提供相关方法和输入输出field
 * @see QuestionDemo
 */

public interface Question {
    String getQuestionName();
    List<Input[]> getInputsList();
    List<Answer> getAnswers();
    TestEntry getTestEntry();

    default int[] reprintInputs(){
        return new int[]{};
    }
}
