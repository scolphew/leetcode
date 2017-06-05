package lsf._400_NthDigit;

public class Solution {
    //找到123456789101112131415...序列的第n个数字
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return s.charAt((n - 1) % len) - '0';
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(12));
    }
}
