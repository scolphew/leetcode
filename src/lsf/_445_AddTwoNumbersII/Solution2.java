package lsf._445_AddTwoNumbersII;

import base.ListNode;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode curr = new ListNode(0);
        int tmp = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) tmp += l1.val;
            if (l2 != null) tmp += l2.val;
            curr.val = tmp % 10;
            tmp /= 10;
            ListNode head = new ListNode(tmp);
            head.next = curr;
            curr = head;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return curr.val == 0 ? curr.next : curr;
    }

    private ListNode reverse(ListNode l) {
        ListNode pre = new ListNode(0);
        pre.next = null;
        while (l != null) {
            ListNode tmp = l;
            l = l.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new Solution2().addTwoNumbers(
                ListNode.scanf(new int[]{7, 2, 4, 3}),
                ListNode.scanf(new int[]{5, 6, 4})
        );
        ListNode.print(listNode);
    }


}
