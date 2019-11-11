package zrx.com.leetcode.Q0020;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.TestEntry;

import java.util.List;

/**
 * Description
 * Implement strStr()
 * <p>
 * Data
 * 2019/11/10 21:40
 *
 * @author zrx
 * @version 1.0
 */

public class Q0028ImplementStrStrBrute implements Question {
    @Override
    public String getQuestionName() {
        return "Q0028ImplementStrStrBrute";
    }

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputsList(2,
                "hello", "ll",
                "aaaaa", "bba",
                "","a",
                "mississippi","issip"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(int.class, 2, -1,-1,4);
    }

    @Override
    public TestEntry getTestEntry() {
        return TestEntry.getInstance(new Solution0028(), "strStr", String.class, String.class);
    }

    public class Solution0028 {

        //Runtime: 1 ms, faster than 67.61% of Java online submissions for Implement strStr().
        //Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Implement strStr().
        public int strStr(String haystack, String needle) {
            int hLen = haystack.length();
            int nLen = needle.length();

            if(hLen==0||nLen==0){
                if(nLen!=0)
                    return -1;
                else
                    return 0;
            }

            int h = 0;
            while (h < hLen - nLen + 1) {
//                System.err.println(h);
                if (haystack.charAt(h) == needle.charAt(0)) {
                    int i = 1;
                    for (int j = h+1; i < nLen; i++, j++) {
                        if (haystack.charAt(j) != needle.charAt(i)) {
                            break;
                        }
                    }
                    if(i==nLen){
                        return h;
                    }

                }
                h++;

            }
            return -1;
        }
    }
}
