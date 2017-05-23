package lsf._322_CoinChange;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? amount / coins[0] : -1;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{4}, 10));
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 8));
        System.out.println(new Solution().coinChange(new int[]{}, 0));
        System.out.println(new Solution().coinChange(new int[]{4}, 10));
        System.out.println(new Solution().coinChange(new int[]{4}, 10));
    }
}
