package lsf.java._024_SwapNodesinPairs;

import base.ListNode;

/**
 * 把链表两个一组，交换顺序
 * 123456 --> 214365
 * @author scolphew
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode per = new ListNode(0);
        head = second;
        while (true) {
            per.next = second;
            first.next = second.next;
            second.next = first;


            if (first.next != null && first.next.next != null) {
                per = first;
                first = first.next;
                second = first.next;
            } else {
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.scanf(new int[]{1, 2, 3, 4, 5, 6});
        Solution s = new Solution();
        ListNode listNode = s.swapPairs(node);
        ListNode.print(listNode);
    }
}
