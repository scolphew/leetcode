package lsf.java._160_IntersectionofTwoLinkedLists;

import base.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenB = 0;
        ListNode p = headB;
        while (p != null) {
            lenB++;
            p = p.next;
        }
        ListNode newA = new ListNode(0);
        newA.next = headA;
        int lenA = foo(newA);


        int lenC = 0;
        p = headB;
        ListNode pre = null;
        while (p != null) {
            lenC++;
            pre = p;
            p = p.next;
        }
        ListNode res = null;
        lenC = (lenA + lenB - lenC + 1) / 2;


        if (headA == pre) {
            pre = null;
            p = newA.next;
            while (p != null) {
                if (--lenC == 0) {
                    res = p;
                }
                ListNode tmp = p.next;
                p.next = pre;
                pre = p;
                p = tmp;
            }
            headA = pre;
        } else {
            foo(newA);
            headA = newA.next;
        }
        return res;
    }


    public int foo(ListNode root) {
        ListNode pre = null, tmp, p = root.next;

        int index = 0;
        while (p != null) {
            index++;
            tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        root.next = pre;
        return index;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getIntersectionNode(ListNode.scanf(new int[]{1, 2, 3, 4, 5}), ListNode.scanf(new int[]{6, 7, 8, 9}));


        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);

        ListNode g = new ListNode(6);
        ListNode h = new ListNode(7);


        a.next = b;
        b.next = c;
        c.next = e;
        e.next = f;

        g.next = h;
        h.next = e;


        ListNode t = s.getIntersectionNode(a, g);
        ListNode.print(t);

        ListNode.print(a);
        ListNode.print(g);


    }


}
