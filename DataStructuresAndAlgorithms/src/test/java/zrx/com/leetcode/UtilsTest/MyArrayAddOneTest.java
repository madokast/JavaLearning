package zrx.com.leetcode.UtilsTest;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.TestEntry;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * MyArrayAddOneTest
 * <p>
 * Data
 * 2019/11/11 11:21
 *
 * @author zrx
 * @version 1.0
 */

public class MyArrayAddOneTest implements Question {
    @Override
    public String getQuestionName() {
        return "MyArrayAddOneTest";
    }

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputsList(2,
                new int[]{0,0},
                new int[][]{MyArrayTools.getIntArray(3,9),MyArrayTools.getIntArray(0,12)},
                new int[]{0,1},
                new int[][]{MyArrayTools.getIntArray(3,9),MyArrayTools.getIntArray(0,12)},
                new int[]{1,1},
                new int[][]{MyArrayTools.getIntArray(3,9),MyArrayTools.getIntArray(0,12)}
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(int.class,0,0,-1);
    }

    @Override
    public TestEntry getTestEntry() {
        return TestEntry.getInstance(new MyArrayAddOneTest(),"test",int[].class,int[][].class);
    }

    @Override
    public int[] reprintInputs() {
        return new int[]{0};
    }

    public int test(int[] ret,int[][] max){
        return MyArrayTools.addOne(ret,max);
    }
}
