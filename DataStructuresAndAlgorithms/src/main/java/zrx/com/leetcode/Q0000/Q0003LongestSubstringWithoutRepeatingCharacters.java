package zrx.com.leetcode.Q0000;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * 我的想法：一个map解决？
 * map中存放字符出现的位置
 *
 * <p>
 * Data
 * 2019/11/10 14:02
 *
 * @author zrx
 * @version 1.0
 */

public class Q0003LongestSubstringWithoutRepeatingCharacters {
    public static void test() {
        System.err.println("Q0003LongestSubstringWithoutRepeatingCharacters");
        final Solution0003 s = new Solution0003();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(s.lengthOfLongestSubstring("abba"));//2

    }
}

class Solution0003 {
    //Runtime: 7 ms, faster than 82.37% of Java online submissions for Longest Substring Without Repeating Characters.
    //Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (map.containsKey(c)) {
                //这神来之笔
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }
}
