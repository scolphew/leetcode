package lsf.java._441_ArrangingCoins;

public class Solution {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(1 + 8.0 * n) - 1) / 2;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(5));
        System.out.println(new Solution().arrangeCoins(8));
        System.out.println(new Solution().arrangeCoins(6));
        System.out.println(new Solution().arrangeCoins(1804289383));
        System.out.println(new Solution().arrangeCoins(1));
    }
}
