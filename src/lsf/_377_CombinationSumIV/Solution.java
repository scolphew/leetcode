package lsf._377_CombinationSumIV;

import java.util.Arrays;

public class Solution {

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < i) {
                    tmp += dp[i - nums[j]];
                } else if (nums[j] == i) {
                    tmp++;
                    break;
                }
            }
            dp[i] = tmp;
        }
        return dp[target];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(new int[]{1, 2, 3}, 4));
    }

}
