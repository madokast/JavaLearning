package zrx.com.leetcode.utils.singlyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * leetcode中的数据结构 单链表
 * **
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 * *
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

    public static ListNode make(int... ints) {
        final ListNode head = new ListNode(ints[0]);
        ListNode node = head;
        for (int i = 1; i < ints.length; i++) {
            node.next = new ListNode(ints[i]);
            node = node.next;
        }

        return head;
    }

    public void print() {
        ListNode node = this;

        System.out.print("SinglyLinkedList[");

        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

        System.out.print(node.val + "]\n");
    }

    public int[] toArray() {
        ListNode node = this;

        List<Integer> list = new ArrayList<>();

        while (node.next != null) {
            list.add(node.val);
            node = node.next;
        }

        list.add(node.val);

        int[] ans = new int[list.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public int length(){
        return this.toArray().length;
    }

    @Override
    public String toString() {
        return "ListNode:" + Arrays.toString(this.toArray()).replaceAll(", ","->");
    }


    public static boolean equals(ListNode a, ListNode b) {
        if(a==null&&b==null){
            return true;
        }

        if(a==null||b==null){
            return false;
        }

        return Arrays.equals(a.toArray(),b.toArray());

//        ListNode ai = a;
//        ListNode bj = b;
//
//        if (ai == null && bj == null) {
//            return true;
//        }
//
//        if (ai == null || bj == null) {
//            return false;
//        }
//
//        //测试 a b 均不为null
//
//        while (ai.next != null && bj.next != null) {
//            if (ai.val != bj.val) {
//                return false;
//            }
//            ai = ai.next;
//            bj = bj.next;
//        }
//
//        //此时 ai bj 必有一个到末尾
//
//        //ai没有到末尾
//        if (ai.next != null) {
//            return false;
//        }
//
//        //bj没有到末尾
//        if (bj.next != null) {
//            return false;
//        }
//
//        //ai bj 均到末尾
//        return ai.val == bj.val;
    }
}
