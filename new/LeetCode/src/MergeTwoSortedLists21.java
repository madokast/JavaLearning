public class MergeTwoSortedLists21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists21 mergeTwoSortedLists21 = new MergeTwoSortedLists21();
        ListNode l1 = mergeTwoSortedLists21.new ListNode(2);
        l1.next = mergeTwoSortedLists21.new ListNode(3);


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode t = listNode;
        int a1, a2;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                t.next = l2;
                break;
            } else if (l2 == null) {
                t.next = l1;
                break;
            } else {
                a1 = l1.val;
                a2 = l2.val;
                if (a1 > a2) {
                    t.next = new ListNode(a2);
                    t = t.next;
                    l2 = l2.next;
                } else {
                    t.next = new ListNode(a1);
                    t = t.next;
                    l1 = l1.next;
                }
            }
        }
        return listNode.next;
    }

}

///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//    }
//}
