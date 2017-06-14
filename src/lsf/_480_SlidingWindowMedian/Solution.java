package lsf._480_SlidingWindowMedian;

import base.Print;

import java.util.PriorityQueue;

public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        double[] ans = new double[m];
        PriorityQueue<Long> large = new PriorityQueue<>();
        PriorityQueue<Long> small = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            large.offer((long) nums[i]);
            small.offer(-large.poll());
            if (large.size() < small.size())
                large.offer(-small.poll());

            if (i - k + 1 >= 0) {
                if (k % 2 == 0)
                    ans[i - k + 1] = (large.peek() - small.peek()) / 2.0;
                else
                    ans[i - k + 1] = large.peek();

                long toRemove = nums[i - k + 1];
                if (toRemove >= large.peek()) {
                    large.remove(toRemove);
                } else {
                    small.remove(-toRemove);
                    small.offer(-large.poll());
                }
                if (large.size() < small.size())
                    large.offer(-small.poll());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Print.print(s.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4));

    }


}
