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

public class Q0028ImplementStrStrKMP implements Question {
    @Override
    public String getQuestionName() {
        return "Q0028ImplementStrStrKMP";
    }

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputsList(2,
                "hello", "ll",
                "aaaaa", "bba",
                "", "a",
                "mississippi", "issip",
                "",""
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(int.class, 2, -1, -1, 4,0);
    }

    @Override
    public TestEntry getTestEntry() {
        return TestEntry.getInstance(new Solution0028(), "strStr", String.class, String.class);
    }

    public class Solution0028 {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0)
                return 0;
            if (haystack.length() == 0)
                return -1;

            char[] h = haystack.toCharArray();
            char[] n = needle.toCharArray();
            int[] back = back(needle);
            int j = 0;
            for (int i = 0; i < h.length; ) {
                if (h[i] == n[j]) {
                    if (j == n.length - 1) {
//                    System.out.println("i = " + i);
//                    System.out.println("j = " + j);
                        return i - n.length + 1;
                    }
                    i++;
                    j++;
                } else {
//                System.out.println("失配 i,j="+i+" "+j);
                    if (j == 0)
                        i++;
                    else {
                        if(isAllSame(n,0,j)&&h[i] == n[j-1]){
                            j--;
                        }else{
                            j -= back[j];
                        }
                    }
                }
            }

            return -1;
        }

        public int[] back(String needle) {
            char[] n = needle.toCharArray();
            int[] arr = new int[(n.length > 2) ? n.length : 2];
            arr[0] = 0;
            arr[1] = 1;

            for (int j = 2; j < n.length; j++) {
                if(isAllSame(n, 0, j)){
                    arr[j] = j;
//                System.out.println("same+"+j);
                }else {
                    arr[j] = j - longestMatch(n, 0, j);
                }



            }

            return arr;
        }

        public boolean isAllSame(char[] arr, int s, int e){
            for (; s < e-1; s++) {
                if(arr[s]!=arr[s+1])
                    return false;
            }
//        System.out.println("s = " + s);
//        System.out.println("e = " + e);
//        System.out.println("same");
            return true;
        }

        public int longestMatch(char[] arr, int s, int e) {
            int max = 0;
            for (int len = 1; len < e - s; len++) {
                if (isMarch(arr, s, e - len, len))
                    max = len;
            }
//        System.out.println("longestMatch="+max);
            return max;
        }

        public boolean isMarch(char[] arr, int s1, int s2, int length) {
            for (int i = 0; i < length; i++) {
                if (arr[s1 + i] != arr[s2 + i])
                    return false;
            }
            return true;
        }

        public int strStr1(String haystack, String needle) {
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                int j;
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j))
                        break;
                }
                if (j == needle.length())
                    return i;
            }

            return -1;
        }
    }
}
