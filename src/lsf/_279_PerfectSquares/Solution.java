package lsf._279_PerfectSquares;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int tmp = dp[i - j * j] + 1;
                if (tmp < dp[i])
                    dp[i] = tmp;
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(15));
    }
}
