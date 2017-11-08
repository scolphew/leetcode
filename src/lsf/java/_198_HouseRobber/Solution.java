package lsf.java._198_HouseRobber;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        int a = 0, b = 0;
        for (int i : nums) {
            int tmp = b;
            if (a + i > b)
                b = a + i;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob2(new int[]{}));
        System.out.println(new Solution().rob2(new int[]{1}));
        System.out.println(new Solution().rob2(new int[]{1, 4, 2}));
    }


}
