package lsf.java._122_BestTimetoBuyandSellStockII;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                res += prices[i - 1] - min;
                min = prices[i];
            }
        }
        return res + prices[prices.length - 1] - min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{1, 3, 5, 7, 1}));
    }
}
