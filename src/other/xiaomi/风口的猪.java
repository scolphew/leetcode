package other.xiaomi;

/**
 * @author scolphew
 */
public class 风口的猪 {
    /**
     * 数组中第i个元素（prices[i]）代表该股票第i天的股价。
     * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，
     * 并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。
     * 设计算法，计算你能获得的最大收益。
     *
     * @param prices
     * @return
     */
    public int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }

    public static void main(String[] args) {
        风口的猪 s = new 风口的猪();
        System.out.println(s.calculateMax(new int[]{3, 8, 5, 1, 7, 8}));
    }

}
