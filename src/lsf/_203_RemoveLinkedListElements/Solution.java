package lsf._203_RemoveLinkedListElements;

import base.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode curr = head, prev = tmp;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return tmp.next;
    }
}
