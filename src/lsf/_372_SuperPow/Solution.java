package lsf._372_SuperPow;

public class Solution {

    static final int M = 1337;

    public int normalPow(int a, int b) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) != 0)
                res = res * a % M;
            a = a * a % M;
            b >>= 1;
        }
        return res;
    }

    public int superPow(int a, int[] b) {
        a %= M;
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = result * normalPow(a, b[i]) % M;
            a = normalPow(a, 10);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().normalPow(2, 100));
    }
}
