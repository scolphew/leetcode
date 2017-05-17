package lsf._329_LongestIncreasingPathinaMatrix;

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int ans = 1;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, foo(dp, matrix, i, j, 1));
            }
        }
        return ans;
    }

    private int foo(int[][] dp, int[][] matrix, int i, int j, int l) {
        if (dp[i][j] != 0)
            return dp[i][j];
        int tmp = matrix[i][j];
        int ans = l;
        matrix[i][j] = Integer.MIN_VALUE;

        if (i - 1 >= 0 && matrix[i - 1][j] > tmp)
            ans = Math.max(ans, dp[i - 1][j] == 0 ? foo(dp, matrix, i - 1, j, 1) + l : dp[i - 1][j] + l);

        if (i + 1 < matrix.length && matrix[i + 1][j] > tmp)
            ans = Math.max(ans, dp[i + 1][j] == 0 ? foo(dp, matrix, i + 1, j, 1) + l : dp[i + 1][j] + l);

        if (j - 1 >= 0 && matrix[i][j - 1] > tmp)
            ans = Math.max(ans, dp[i][j - 1] == 0 ? foo(dp, matrix, i, j - 1, 1) + l : dp[i][j - 1] + l);

        if (j + 1 < matrix[0].length && matrix[i][j + 1] > tmp)
            ans = Math.max(ans, dp[i][j + 1] == 0 ? foo(dp, matrix, i, j + 1, 1) + l : dp[i][j + 1] + l);

        matrix[i][j] = tmp;
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestIncreasingPath(
                new int[][]{
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}
                }
        ));
    }
}
