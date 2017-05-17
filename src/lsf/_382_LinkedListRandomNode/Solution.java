package lsf._382_LinkedListRandomNode;

import base.ListNode;

import java.util.Random;

public class Solution {
    ListNode head;
    Random random;
    int length;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
        this.length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode fakehead = head;
        Random r = new Random();
        int random = r.nextInt(length);
        for (int i = 0; i < random; i++) {
            fakehead = fakehead.next;
        }
        return fakehead.val;
    }

    public static void main(String[] args) {
        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        Solution s = new Solution(r);

        for (int i = 0; i < 100; i++) {
            System.out.println(s.getRandom());
        }

    }

}
