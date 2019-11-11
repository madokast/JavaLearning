package zrx.com.leetcode.utils.LeerCodeTest;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Description
 * Question接口的一个实现示例
 * <p>
 * Data
 * 2019/11/10 15:30
 *
 * @author zrx
 * @version 1.0
 */

public class QuestionDemo implements Question {
    @Override
    public String getQuestionName() {
        return "SolutionXXXX";
    }

    @Override
    public List<Input[]> getInputsList() {
//        return Input.makeInputsList(
//                new Input[]{
//                        Input.newInstance(5),
//                        Input.newInstance("zrx"),
//                },
//                new Input[]{
//                        Input.newInstance(7),
//                        Input.newInstance("ab"),
//                }
//        );

        return Input.makeInputsList(2,
                5,"zrx",
                7,"ab"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(
                Answer.getInstance(int.class,8),
                Answer.getInstance(int.class,9)
        );
    }

    @Override
    public TestEntry getTestEntry() {
        return TestEntry.getInstance(new SolutionXXXX(),"add",int.class,String.class);
    }
}

class SolutionXXXX {
    public int add(int aInt, String name) {
        return aInt + name.length();
    }
}
