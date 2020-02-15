package lsf.java._03_._300_LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    //求最长递增子数组
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int n : map.keySet()) {
                if (nums[i] > n) {
                    if (tmp < map.get(n) + 1)
                        tmp = map.get(n) + 1;
                } else {
                    break;
                }
            }
            map.put(nums[i], tmp);
        }
        //System.out.println(map);
        int ans = 0;
        for (int i : map.values())
            if (i > ans)
                ans = i;
        return ans;
    }


    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }

        return len;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS2(new int[]{1, 2, 0, 5, 1, 2, 3, 4}));
        System.out.println(s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(s.lengthOfLIS(new int[]{0}));
    }
}
