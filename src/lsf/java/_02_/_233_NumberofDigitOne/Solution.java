package lsf.java._02_._233_NumberofDigitOne;

public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return count;
    }

    public int foo(int n) {
        int count = 0;
        long j = n;
        long i = 1;
        while (j != 0) {
            long high = j / 10;
            count += high * i;
            long tmp = j % 10;
            if (tmp > 1) {
                count += i;
            } else if (tmp == 1) {
                count += n - j * i + 1;
            }
            i *= 10;
            j = n / i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(1410065408));
        System.out.println(new Solution().foo(1410065408));

        int a = 1737167499;

        long b = 1;
        a += b;
        System.out.println(1410065408);
        System.out.println(Integer.MAX_VALUE);
    }
}
