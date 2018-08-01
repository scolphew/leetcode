package lsf.java._600_NonnegativeIntegerswithoutConsecutiveOnes;

public class Solution {
    /**
     * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
     * <p>
     * 如:下面是带有相应二进制表示的非负整数<= 5：
     * 0 : 0
     * 1 : 1
     * 2 : 10
     * 3 : 11
     * 4 : 100
     * 5 : 101
     * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
     */
    public int findIntegers(int num) {
        int ans = 0;
        int w[] = new int[31];
        w[0] = 1;
        w[1] = 2;
        for (int i = 2; i < 31; i++) {
            w[i] = w[i - 1] + w[i - 2];
        }
        int p = 0, t = 30;
        while (t >= 0) {
            if ((num & (1 << t)) != 0) {
                ans += w[t];
                if (p == 1) {
                    return ans;
                }
                p = 1;
            } else {
                p = 0;
            }
            t--;
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findIntegers(1));

        int a = 1;
        int b = 2;
        int c = a & b;
    }
}
