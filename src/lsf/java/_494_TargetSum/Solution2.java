package lsf.java._494_TargetSum;

public class Solution2 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum < S || (sum + S) % 2 != 0) {
            return 0;
        } else {
            return helper(nums, ((sum + S) >>> 1));
        }
    }

    private int helper(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int number : nums) {
            for (int i = sum; i >= number; i--) {
                dp[i] = dp[i] + dp[i - number];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }


}
