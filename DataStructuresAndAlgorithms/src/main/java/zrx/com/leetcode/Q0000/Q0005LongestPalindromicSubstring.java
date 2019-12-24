package zrx.com.leetcode.Q0000;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given a string s, find the longest palindromic substring
 * in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * Data
 * 2019/12/24 14:54
 *
 * @author zrx
 * @version 1.0
 */

public class Q0005LongestPalindromicSubstring implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("babad"),
                Input.InputSet.build("cbbd")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList("bab","bb");
    }

    public class Solution0005 {
        public String longestPalindrome(String s) {

            //TODO
            return null;
        }
    }
}
