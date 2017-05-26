package lsf._343_IntegerBreak;

public class Solution {
    public int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(8));
    }
}
