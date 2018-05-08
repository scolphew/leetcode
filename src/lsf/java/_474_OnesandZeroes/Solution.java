package lsf.java._474_OnesandZeroes;

public class Solution {
    /**
     * @param strs 字符串数组，每个字符串均只有01组成
     * @param m    0的个数
     * @param n    1的个数
     * @return 给定的0和1最多能组成strs中多少个字符串，每个0/1只能用最多一次
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = foo(s);
            for (int i = m; i >= count[0]; i--)
                for (int j = n; j >= count[1]; j--)
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
        }
        return dp[m][n];

    }

    /**
     * 统计str中0和1的数量
     */
    public int[] foo(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray())
            res[c - '0']++;
        return res;
    }

}
