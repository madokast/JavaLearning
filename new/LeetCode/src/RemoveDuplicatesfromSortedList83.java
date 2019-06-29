import com.sun.source.tree.CompilationUnitTree;

public class RemoveDuplicatesfromSortedList83 {
    //**
    //* Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //*/

    public static void printList(ListNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val);
            } else {
                System.out.print(head.val + "->");
            }
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        new RemoveDuplicatesfromSortedList83().test();
    }

    private void test() {
        ListNode head = new ListNode(1);
        ListNode t = head;
        t.next = new ListNode(1);
        t = t.next;
        t.next = new ListNode(2);
        t = t.next;
        t.next = new ListNode(3);
        t = t.next;
        t.next = new ListNode(3);
        printList(head);

        deleteDuplicates(head);
        printList(head);

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode currtentNode = head.next;
        ListNode pastNode = head;
        while (currtentNode != null) {
            if (currtentNode.val == pastNode.val) {
                if(currtentNode.next==null){
                    pastNode.next=null;
                }
            } else {
                pastNode.next = currtentNode;
                pastNode = pastNode.next;
            }


            currtentNode = currtentNode.next;
        }

        return head;
    }
}
