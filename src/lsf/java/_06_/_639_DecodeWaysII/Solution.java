package lsf.java._06_._639_DecodeWaysII;

public class Solution {

    /**
     * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
     * 'A' -> 1
     * 'B' -> 2
     * 'Z' -> 26
     * 除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。
     * 注意： * 不会是0
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;

        int M = 1000000007;
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = chars[0] == '*' ? 9 : chars[0] == '0' ? 0 : 1;
        for (int i = 1; i < N; i++) {
            if (chars[i] == '*') {
                // 当前为是*
                // 只算这一位 9种情况
                dp[i + 1] = 9 * dp[i];
                if (chars[i - 1] == '1') {
                    // 前一位是1, 再加上 11-19 的组合情况9种
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                } else if (chars[i - 1] == '2') {
                    // 前一位是2, 再加上 21-26 的组合情况6种
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                } else if (chars[i - 1] == '*') {
                    // 前一位是*, 再加上 11-19 21-26 的组合情况15种
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
                }
            } else {
                // 当前位不是1
                // 只算当前，是0 不可能，否自1种
                dp[i + 1] = chars[i] == '0' ? 0 : dp[i];
                if (chars[i - 1] == '1') {
                    // 前一个是1， 都可以组合一种
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                } else if (chars[i - 1] == '2' && chars[i] <= '6') {
                    // 前一个是2， 且当前小于6 ，都可以有一种
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                } else if (chars[i - 1] == '*') {
                    // 前一个是*， 当前位 小于6 两种，大于7，一种
                    dp[i + 1] = (dp[i + 1] + (chars[i] <= '6' ? 2 : 1) * dp[i - 1]) % M;
                }
            }
        }
        return (int) dp[N];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("2839"));
    }
}
