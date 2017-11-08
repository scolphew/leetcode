package lsf.java._143_ReorderList;

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


    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;
        // 找中点
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //反转后半部分
        ListNode pre = null, tmp;
        p2 = p1.next;
        while (p2 != null) {
            tmp = p2.next;
            p2.next = pre;
            pre = p2;
            p1.next = p2;
            p2 = tmp;
        }
        //把后面的一半插入前面的一办
        p2 = p1.next;
        p1.next = null;
        p1 = head;
        while (p2 != null) {
            tmp = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = tmp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = ListNode.scanf(new int[]{1, 2, 3, 4, 5, 6, 7});
        s.reorderList2(h);
        ListNode.print(h, 10);
        h = ListNode.scanf(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        s.reorderList2(h);
        ListNode.print(h, 10);
    }

}
