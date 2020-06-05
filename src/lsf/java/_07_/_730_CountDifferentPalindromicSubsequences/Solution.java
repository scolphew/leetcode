package lsf.java._07_._730_CountDifferentPalindromicSubsequences;

public class Solution {

    public int countPalindromicSubsequences(String S) {
        int M = 1000000007;
        int n = S.length();
        char[] chars = S.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if (chars[i] != chars[j]) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                } else {
                    char c = chars[i];
                    int left = i + 1, right = j - 1;
                    while (chars[left] != c)
                        left++;
                    while (chars[right] != c)
                        right--;
                    if (left > right) {
                        //没有
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (left == right) {
                        //只有一个
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                    }
                }
                dp[i][j] = dp[i][j] > 0 ? dp[i][j] % M : dp[i][j] + M;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPalindromicSubsequences("bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada"));
    }

}
