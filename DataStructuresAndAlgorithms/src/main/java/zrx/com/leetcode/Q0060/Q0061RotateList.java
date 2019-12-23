package zrx.com.leetcode.Q0060;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.singlyLinkedList.ListNode;

import java.util.List;
import java.util.Objects;

/**
 * Description
 * 61. Rotate List
 * Given a linked list, rotate the list to
 * the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 *
 * Runtime: 1 ms, faster than 24.59% of Java online submissions for Rotate List.
 * Memory Usage: 37.6 MB, less than 82.76% of Java online submissions for Rotate List.
 *
 * <p>
 * Data
 * 2019/12/23 7:34
 *
 * @author zrx
 * @version 1.0
 */

public class Q0061RotateList implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputsList(2,
                ListNode.make(1, 2, 3, 4), 0,
                ListNode.make(1, 2, 3, 4), 1,
                ListNode.make(1, 2, 3, 4), 2,
                ListNode.make(1, 2, 3, 4), 3,
                ListNode.make(1, 2, 3, 4), 4,
                ListNode.make(1, 2, 3, 4), 5,
                ListNode.make(1, 2, 3, 4), 6
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(ListNode.class,
                ListNode.make(1, 2, 3, 4),
                ListNode.make(2, 3, 4, 1),
                ListNode.make(3, 4, 1, 2),
                ListNode.make(4, 1, 2, 3),
                ListNode.make(1, 2, 3, 4),
                ListNode.make(2, 3, 4, 1),
                ListNode.make(3, 4, 1, 2)
        );
    }


    public class Solution0061 {
        public ListNode rotateRight(ListNode head, int k) {
            //判空
            if (head == null) {
                return null;
            }

            //只有一个元素
            if (head.next == null) {
                return head;
            }

            //不循环
            if(k==0){
                return head;
            }

            int kk = k; // 复制一下
            //拿到当前头指针、尾指针 和 链表长度..

            int length = 1;
            ListNode nowHead = head; //当前头指针
            ListNode nowTail = head; //当前尾指针
            ListNode newHead = null; //新的头指针
            ListNode newTail = null; //新的尾指针

            //如果kk=1，那么当前头指针将会是新的尾指针
            if(kk==1){
                newTail = nowHead;
            }

            while (nowTail.next != null) {
                nowTail = nowTail.next;
                length++;
                kk--;

                if(kk==1){
                    newTail = nowTail;
                }

                if(kk==0){
                    newHead = nowTail;
                }
            }

            //如果kk的值大于等于length ，那么上面循环拿不到 newTail 和 newHead
            if(k>length){
                kk = k%length;

                //再次寻找 newTail 和 newHead
                ListNode node = head;

                if(kk==1){
                    newTail = nowHead;
                }

                while (node.next != null) {
                    node = node.next;
                    kk--;

                    if(kk==1){
                        newTail = node;
                    }

                    if(kk==0){
                        newHead = node;
                        break;
                    }
                }

            }else if(k==length){
                return head;
            }
//            else {
//                MyRequire.requireTrue(newHead!=null);
//                MyRequire.requireTrue(newTail!=null);
//            }


            //此时一定找到了 newTail 和 newHead
            Objects.requireNonNull(newHead);
            Objects.requireNonNull(newTail);

//            System.out.println("newHead = " + newHead.val);
//            System.out.println("newTail = " + newTail.val);

            newTail.next = null;
            nowTail.next = nowHead;

            return newHead;
        }
    }
}
