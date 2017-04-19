package lsf._138_CopyListwithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode new_head = new RandomListNode(0);

        RandomListNode p = new_head;
        while (head != null) {
            RandomListNode tmp;
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.label));
            }
            p.next = map.get(head);

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                p.next.random = map.get(head.random);
            }

            p = p.next;
            head = head.next;
        }

        return new_head.next;

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        RandomListNode root = new RandomListNode(1);
        root.next = new RandomListNode(2);
        root.next = new RandomListNode(3);

        s.copyRandomList(root);
    }

}
