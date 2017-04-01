package lsf._023_MergekSortedLists;

import base.ListNode;

/**
 * 多链表合并
 * @author scolphew
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l1 = ListNode.scanf(new int[]{1, 2, 3});
        ListNode l2 = ListNode.scanf(new int[]{2, 3, 4});
        ListNode l3 = ListNode.scanf(new int[]{1, 2, 3});
        ListNode l4 = ListNode.scanf(new int[]{1, 2, 3});


        ListNode[] ls = new ListNode[]{l1, l2, l3, l4};
        ListNode l = s.mergeKLists(ls);
        //ListNode l = s.mergeTwoLists(ls[0], ls[1]);
        ListNode.print(l);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        return mergeKLists(lists, 0, lists.length - 1);
    }

    ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) >>> 1;

        ListNode l1 = mergeKLists(lists, left, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, right);

        ListNode result = new ListNode(0);
        ListNode p = result;
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next=l1==null?l2:l1;
        return result.next;
    }
}
