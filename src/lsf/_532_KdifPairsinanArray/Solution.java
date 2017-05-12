package lsf._532_KdifPairsinanArray;

import java.util.Arrays;

public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 1;
        int ans = 0;
        while (i < nums.length && j < nums.length) {
            if (i == j) {
                j++;
            } else if (nums[j] - nums[i] == k) {
                ans++;
                i++;

                while (i < nums.length && nums[i] == nums[i - 1])
                    i++;
                j = i + 1;

            } else if (nums[j] - nums[i] < k) {
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPairs(new int[]{1, 1, 1, 2, 2, 2}, 0));
        System.out.println(s.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(s.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    }
}
