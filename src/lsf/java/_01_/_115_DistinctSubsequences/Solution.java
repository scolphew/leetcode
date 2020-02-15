package lsf.java._01_._115_DistinctSubsequences;

public class Solution {
    /**
     * 求s的走序列中有几个为t
     * @return
     */
    public int numDistinct(String s, String t) {
        int dp[][] = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < t.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[t.length()][s.length()];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDistinct("aabb", "ab"));
    }
}
