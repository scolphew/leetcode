package lsf.java._741_CherryPickup;

public class Solution {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int l = 2 * n - 1;
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int k = 1; k < l; k++) {
            for (int x1 = n - 1; x1 >= 0; x1--) {
                int y1 = k - x1;
                for (int x2 = n - 1; x2 >= 0; x2--) {
                    int y2 = k - x2;
                    if (y1 < 0 || y1 >= n || y2 < 0 || y2 >= n || grid[x1][y1] < 0 || grid[x2][y2] < 0) {
                        dp[x1][x2] = -1;
                        continue;
                    } else {
                        if (x1 > 0) dp[x1][x2] = Math.max(dp[x1][x2], dp[x1 - 1][x2]);
                        if (x2 > 0) dp[x1][x2] = Math.max(dp[x1][x2], dp[x1][x2 - 1]);
                        if (x1 > 0 && x2 > 0) dp[x1][x2] = Math.max(dp[x1][x2], dp[x1 - 1][x2 - 1]);
                        if (dp[x1][x2] >= 0) dp[x1][x2] += grid[x1][y1] + (x1 == x2 ? 0 : grid[x2][y2]);
                    }
                }
            }
        }
        return Math.max(dp[n - 1][n - 1], 0);
    }

    public static void main(String[] args) {
        Solution m = new Solution();
        System.out.println(m.cherryPickup(
                new int[][]{
                        {1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1}
                }
        ));
    }

}
