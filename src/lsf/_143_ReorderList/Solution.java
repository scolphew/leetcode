package lsf._143_ReorderList;

import base.ListNode;

public class Solution {

    /**
     * 把链表变为   1 n 2 n-1 3 n-2 ...
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode pre = null;
        ListNode tmp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }

        ListNode t1, t2;
        if (fast != null) {
            tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
            t1 = pre;
            t2 = slow;
        } else {
            t1 = slow;
            t2 = pre;
        }

        //把t2 插入t1
        fast = t1;
        while (t2 != null) {
            tmp = t2.next;
            t2.next = t1.next;
            t1.next = t2;
            t1 = t2.next;
            t2 = tmp;

        }
        pre = null;
        while (fast != null) {
            tmp = fast.next;
            fast.next = pre;
            pre = fast;
            fast = tmp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = ListNode.scanf(new int[]{1, 2, 3, 4, 5, 6, 7});
        s.reorderList(h);
        ListNode.print(h, 10);
        h = ListNode.scanf(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        s.reorderList(h);
        ListNode.print(h, 10);
    }

}
