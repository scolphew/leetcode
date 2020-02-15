package lsf.java._01_._188_BestTimetoBuyandSellStockIV;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2)
            return quickSolve(prices);
        int dp[][] = new int[k + 1][2];

        for (int i = 0; i <= k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                dp[i][0] = Math.max(dp[i - 1][1] - price, dp[i][0]);
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + price);
            }
        }
        return dp[k][1];
    }

    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(1, new int[]{1}));
    }
}
