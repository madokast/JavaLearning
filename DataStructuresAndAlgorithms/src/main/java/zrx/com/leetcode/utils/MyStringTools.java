package zrx.com.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 字符串工具
 * <p>
 * Data
 * 2019/11/11 10:27
 *
 * @author zrx
 * @version 1.0
 */

public class MyStringTools {
    public static int[] allIndexOfWithCover(String words, String word) {
        List<Integer> ansList = new ArrayList<>();
        int start = 0;
        int ans = -1;
        while (start < words.length() - word.length() + 1) {
            if ((ans = words.indexOf(word, start)) != -1) {
                ansList.add(ans);
                start = ans + 1;
            } else {
                break;
            }
        }

        return MyArrayTools.listToIntArray(ansList);
    }
}
