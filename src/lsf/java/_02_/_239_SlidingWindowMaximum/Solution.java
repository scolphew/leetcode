package lsf.java._02_._239_SlidingWindowMaximum;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        if (len < 1 || k == 0) {
            return new int[0];
        }
        int[] ans = new int[len];
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> dq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
            dq.offer(nums[i]);
        }
        ans[0] = dq.peek();
        dq.remove(queue.poll());

        for (int i = k; i < nums.length; i++) {
            queue.offer(nums[i]);
            dq.offer(nums[i]);
            ans[i - k + 1] = dq.peek();
            dq.remove(queue.poll());
        }
        return ans;
    }


    public int[] foo(int nums[], int k) {
        if (nums == null || k <= 0)
            return new int[0];
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();//存最大的序号
        for (int i = 0; i < k; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            q.offer(i);
        }
        ans[index++] = nums[q.peek()];
        for (int i = k; i < nums.length; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            q.offer(i);
            ans[index++] = nums[q.peek()];
        }
        return ans;

    }

    public static void main(String[] args) {
        new Solution().foo(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

}
