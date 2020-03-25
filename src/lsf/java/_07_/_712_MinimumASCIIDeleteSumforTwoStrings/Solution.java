package lsf.java._07_._712_MinimumASCIIDeleteSumforTwoStrings;

public class Solution {

    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i + 1][0] = dp[i][0] + c1[i];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j + 1] = dp[0][j] + c2[j];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = c1[i] == c2[j] ? dp[i][j] : (dp[i][j] + c1[i] + c2[j]);
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 1][j] + c2[j]);
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j + 1] + c1[i]);
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%5d", dp[i][j]);

            }
            System.out.println();
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumDeleteSum(
                "delete"
                , "leet"));
    }

}
