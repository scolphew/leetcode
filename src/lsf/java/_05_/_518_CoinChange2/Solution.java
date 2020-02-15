package lsf.java._05_._518_CoinChange2;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j : coins) {
            for (int i = j; i <= amount; i++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.change(100, new int[]{1, 2, 3, 4, 5}));
    }
}
