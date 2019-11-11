package zrx.com.leetcode.utils.singlyLinkedList;

import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * leetcode中的数据结构 单链表
 * **
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 *  *
 * <p>
 * Data
 * 2019/11/10 14:43
 *
 * @author zrx
 * @version 1.0
 */



public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode make(int...ints){
        final ListNode head = new ListNode(ints[0]);
        ListNode node = head;
        for (int i = 1; i < ints.length; i++) {
            node.next = new ListNode(ints[i]);
            node = node.next;
        }

        return head;
    }

    public void print(){
        ListNode node = this;

        System.out.print("SinglyLinkedList[");

        while (node.next!=null){
            System.out.print(node.val+"->");
            node = node.next;
        }

        System.out.print(node.val+"]\n");
    }
}
