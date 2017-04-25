package lsf._174_DungeonGame;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[] dp = new int[m];
        dp[m - 1] = Math.max(1, 1 - dungeon[n - 1][m - 1]);
        for (int i = m - 2; i >= 0; --i) {
            dp[i] = Math.max(1, dp[i + 1] - dungeon[n - 1][i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1] = Math.max(1, dp[m - 1] - dungeon[i][m - 1]);
            for (int j = m - 2; j >= 0; --j) {
                dp[j] = Math.max(1, Math.min(dp[j] - dungeon[i][j], dp[j + 1] - dungeon[i][j]));
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        }));
    }
}
