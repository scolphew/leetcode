package lsf._025_ReverseNodesinkGroup;

import lsf._000_base.ListNode;

/**
 * @author scolphew
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode result = null;
        /**
         * 反转数组的前k个
         */
        ListNode p = head;
        ListNode next = p.next;
        boolean flag = false;//链表长度小于k
        for (int i = 1; i < k; i++) {
            if(next==null) {
                flag = true;
                break;
            }
            result = next;
            next = next.next;
            result.next = p;
            p = result;
        }
        head.next = next;


        //如果链表长度小于k，直接返回
        if (flag) {
            result = reverse(p);
            return result;
        } else {
            next = reverseKGroup(next, k);
            head.next=next;
            return result;
        }

    }

    /**
     * 反转链表
     */
    ListNode reverse(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode p = head;
        ListNode result = null;
        ListNode next = p.next;

        while (next!=null){
            result=next;
            next=next.next;
            result.next=p;
            p=result;
        }
        head.next=next;
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = ListNode.scanf(new int[]{1,2,3,4,5});
        //System.out.println(s.reverse(node));
        System.out.println(s.reverseKGroup(node, 9));
    }


}
