package zrx.com.leetcode.utils.LeerCodeTest;

import zrx.com.leetcode.utils.MyRequire;

import java.util.List;

/**
 * 所有leetcode题目实现这个接口
 * 并提供相关方法和输入输出field
 * @see QuestionDemo
 */

public interface Question {
    default String getQuestionName(){
        final String[] splits = this.getClass().toString().split("\\.");
        return splits[splits.length-1];
    }
    List<Input[]> getInputsList();
    List<Answer> getAnswers();
    default TestEntry getTestEntry(){
        final String className = "Solution" + this.getQuestionName().substring(1,5);
        for (Class<?> declaredClass : this.getClass().getDeclaredClasses()) {
            if(declaredClass.toString().contains(className)){
                return TestEntry.getInstance(declaredClass);
            }
        }
        MyRequire.throwRunTimeException("请声明内部类Solution+题号");
        return null;
    }

    default int[] reprintInputs(){
        return new int[]{};
    }
}
