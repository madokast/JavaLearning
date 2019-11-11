package zrx.com.leetcode.Q0000;

import zrx.com.leetcode.utils.singlyLinkedList.ListNode;

/**
 * Description
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 *
 * 移走倒数第n个元素
 * 典型的双指针问题
 *
 * <p>
 * Data
 * 2019/11/10 14:31
 *
 * @author zrx
 * @version 1.0
 */

public class Q0019RemoveNthNodeFromEndOfList {
    public static void test(){
        System.err.println("Q0019RemoveNthNodeFromEndOfList");
        final Solution0019 s = new Solution0019();
        s.removeNthFromEnd(ListNode.make(1,2,3,4,5),1).print();
        s.removeNthFromEnd(ListNode.make(1,2,3,4,5),2).print();
        s.removeNthFromEnd(ListNode.make(1,2,3,4,5),3).print();
        s.removeNthFromEnd(ListNode.make(1,2,3,4,5),4).print();
        s.removeNthFromEnd(ListNode.make(1,2,3,4,5),5).print();

        s.removeNthFromEnd(ListNode.make(1,2),1).print();
        s.removeNthFromEnd(ListNode.make(1,2),2).print();

    }
}


class Solution0019 {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
    //Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        ListNode left = null;

        while (right.next!=null){
            right = right.next;

            if(n>0){
                n--;
                if(n==0){
                    left = head;
                    n = -1;
                }
            }else {
                left = left.next;
            }
        }

        //出循环后，right是最后一个元素
        //我想让left=要删除的元素的前一个元素

        if(left==null){
            //要删除的是头元素
            head = head.next;
        }else if(left.next==right){
            //要删除的是最后一个元素
            left.next=null;
        }else {
            left.next = left.next.next;
        }

        return head;

    }
}

