package lsf._135_Candy;

public class Solution {
    public static int candy(int[] ratings) {
        int candys[] = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candys[i] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candys[i] = candys[i - 1] + 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candys[i] = Math.max(candys[i], candys[i + 1] + 1);
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += candys[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 3, 2, 4, 6, 4, 2, 6, 8, 45, 8, 4, 6}));
        System.out.println(candy(new int[]{1, 3, 2, 4, 6}));
        System.out.println(candy(new int[]{2, 1}));
        System.out.println(candy(new int[]{5, 3, 1}));
    }
}
