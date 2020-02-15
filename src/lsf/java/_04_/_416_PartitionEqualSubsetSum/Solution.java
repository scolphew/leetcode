package lsf.java._04_._416_PartitionEqualSubsetSum;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 == 1)
            return false;
        sum >>>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 2, 2}));
    }
}
