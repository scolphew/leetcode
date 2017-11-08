package lsf.java._206_ReverseLinkedList;

import base.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, tmp;
        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
