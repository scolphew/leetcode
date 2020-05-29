package lsf.java._07_._719_FindKthSmallestPairDistance;

import java.util.Arrays;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + ((r - l) >>> 1);
            int count = 0;
            int start = 0;
            for (int i = 0; i < n; i++) {
                while (nums[i] - nums[start] > mid) {
                    start++;
                }
                count += i - start;
            }

            if (count < k)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.smallestDistancePair(new int[]{1, 2, 4, 7, 10, 10, 10, 10}, 2);
    }
}
