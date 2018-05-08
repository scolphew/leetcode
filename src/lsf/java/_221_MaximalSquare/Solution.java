package lsf.java._221_MaximalSquare;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    if (dp[i][j] > res)
                        res = dp[i][j];
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][]{
                {'1', '0'},
                {'1', '1'},
        }));
    }
}
