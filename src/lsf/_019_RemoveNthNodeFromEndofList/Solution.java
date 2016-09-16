package lsf._019_RemoveNthNodeFromEndofList;

import lsf._000_base.ListNode;

/**
 * 移除链表倒数第n个节点
 * @author scolphew
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        } else if (head.next == null && n == 1) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;

        if (n == 1) {
            while (p.next != null) {
                q = p;
                p = p.next;
            }
            q.next = null;
            return head;
        }

        q = head;
        while (p.next != null) {
            p = p.next;
            for (int i = 0; i < n; i++) {
                if (q.next == null)
                    q = head;
                else {
                    q = q.next;
                }

            }
        }
        if (q == head) {
            System.out.println("head");
            return q.next;
        } else {
            q.val = q.next.val;
            q.next = q.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = ListNode.scanf(new int[]{1, 2, 3});

        ListNode.print(s.removeNthFromEnd2(node, 3));
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }

        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        if (p == null)
            return head.next;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}
