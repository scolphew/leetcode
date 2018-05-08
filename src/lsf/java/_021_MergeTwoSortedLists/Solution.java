package lsf.java._021_MergeTwoSortedLists;

import base.ListNode;

/**
 * 双链表合并
 * @author scolphew
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result;
        ListNode p;

        if (l1.val < l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }
        p = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null)
            p.next = l2;
        else
            p.next = l1;
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.scanf(new int[]{1, 3, 4, 6, 7});
        ListNode l2 = ListNode.scanf(new int[]{2, 4, 6});
        ListNode l3 = null;

        Solution s = new Solution();
        ListNode listNode = s.mergeTwoLists(l1, l2);
        ListNode.print(listNode);
    }
}
