package lsf.java._629_KInversePairsArray;

import base.Print;

public class Solution {

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k && j <= i * (i - 1) / 2; j++) {
                int val = j - i >= 0 ? dp[i - 1][j - i] : 0;
                val = (dp[i - 1][j] - val + M) % M;
                dp[i][j] = (dp[i][j - 1] + val) % M;
            }
        }
        Print.print(dp);
        return dp[n][k];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.kInversePairs(100, 60));
    }
}
