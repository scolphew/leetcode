package lsf.java._07_._714_BestTimetoBuyandSellStockwithTransactionFee;

public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int no = 0;// 今天如果手里没有股票的情况下，拥有资金
        int yes = -prices[0];// 如果手里有股票的花，拥有资金
        for (int i = 1; i < prices.length; i++) {
            // 今天结束之后，手里没有股票
            // 情况一：昨天没有，今天不买   no
            // 情况而：昨天有，今天卖了  yes+p-fee
            no = Math.max(no, yes + prices[i] - fee);

            // 今天结束之后，手里有股票
            // 情况一：昨天没有，今天买了   no-p    yes+p-f-p=yes-f
            // 如果上面的不等式取右侧，则下面的肯定取左侧，所以不需要缓存NO
            // 情况二：昨天有，今天啥都没干   yes
            // 情况三：昨天有，今天买新的了    不存在
            yes = Math.max(yes, no - prices[i]);
        }

        return no;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{1, 9, 3}, 1));
    }

}
