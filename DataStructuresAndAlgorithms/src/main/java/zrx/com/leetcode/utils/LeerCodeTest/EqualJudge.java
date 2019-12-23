package zrx.com.leetcode.utils.LeerCodeTest;

import zrx.com.leetcode.utils.MyRequire;
import zrx.com.leetcode.utils.singlyLinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description
 * 判断相同的方法
 * <p>
 * Data
 * 2019/11/10 16:35
 *
 * @author zrx
 * @version 1.0
 */

public class EqualJudge {
    private static Map<Class, EqualMethod> map = new HashMap<>();

    static {
        map.put(int[].class, (o1, o2) -> MyRequire.isEqual((int[]) o1, (int[]) o2));
        map.put(ListNode.class, (o1, o2) -> ListNode.equals((ListNode) o1, (ListNode) o2));
    }


    static boolean judge(Class clazz, Object o1, Object o2) {
        return map.getOrDefault(clazz, Objects::equals).equal(o1, o2);
    }
}
