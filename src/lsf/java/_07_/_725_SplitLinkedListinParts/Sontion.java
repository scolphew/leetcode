package lsf.java._07_._725_SplitLinkedListinParts;

import base.ListNode;

public class Sontion {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p = root;
        int n = 0; // 长度
        while (p != null) {
            p = p.next;
            n++;
        }

        int width = n / k, rem = n % k;

        ListNode[] ans = new ListNode[k];
        p = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = p;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (p != null)
                    p = p.next;
            }
            if (p != null) {
                ListNode tmp = p;
                p = p.next;
                tmp.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }

}
