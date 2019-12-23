package zrx.com.leetcode.UtilsTest;

import org.junit.Test;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyRandom;
import zrx.com.leetcode.utils.MyRequire;
import zrx.com.leetcode.utils.singlyLinkedList.ListNode;

import java.util.Arrays;

/**
 * Description
 * ListNode 测试
 * <p>
 * Data
 * 2019/12/23 8:04
 *
 * @author zrx
 * @version 1.0
 */

public class ListNodeTest {
    @Test
    public void test(){
        MyTools.printCurrentMethod(true,"ListNodeTest");
        for (int i = 0; i < 5; i++) {
            final int[] ints = MyRandom.randomIntArray(100, 20 + i);
            final ListNode node = ListNode.make(ints);
            System.out.println(node);
            MyRequire.requireTrue(Arrays.equals(node.toArray(),ints));
        }

        System.out.println("测试通过");
    }
}
