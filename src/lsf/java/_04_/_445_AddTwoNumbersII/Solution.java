package lsf.java._04_._445_AddTwoNumbersII;

import base.ListNode;

import java.util.Stack;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int tmp = 0;
        ListNode curr = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) tmp += s1.pop();
            if (!s2.empty()) tmp += s2.pop();
            curr.val = tmp % 10;
            ListNode head = new ListNode(tmp / 10);
            head.next = curr;
            curr = head;
            tmp /= 10;
        }

        return curr.val == 0 ? curr.next : curr;
    }

}
