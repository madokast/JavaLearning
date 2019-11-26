package zrx.com.leetcode.UtilsTest;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.TestEntry;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyStringTools;

import java.util.List;

/**
 * Description
 * MyStringAllIndexOfTest
 * <p>
 * Data
 * 2019/11/11 10:35
 *
 * @author zrx
 * @version 1.0
 */

public class MyStringAllIndexOfTest implements Question {
    @Override
    public String getQuestionName() {
        return "MyStringAllIndexOfTest";
    }

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputsList(2,
                "aa","a",
                "aab","a",
                "barfoothefoobarman","foo",
                "barfoothefoobarman","bar"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(int[].class,
                MyArrayTools.getIntArray(0,1),
                MyArrayTools.getIntArray(0,1),
                MyArrayTools.getIntArray(3,9),
                MyArrayTools.getIntArray(0,12)
        );
    }

    @Override
    public TestEntry getTestEntry() {
        return TestEntry.getInstance(new MyStringAllIndexOfTest(),"test",String.class,String.class);
    }

    public int[] test(String s1,String s2){
        return MyStringTools.allIndexOfWithCover(s1,s2);
    }
}
