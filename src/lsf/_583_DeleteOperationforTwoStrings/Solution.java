package lsf._583_DeleteOperationforTwoStrings;

public class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1
                            : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int val = dp[word1.length()][word2.length()];
        return word1.length() - val + word2.length() - val;
    }

    public int minDistance2(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int dp[][] = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i <= chars1.length; i++) {
            for (int j = 0; j <= chars2.length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = chars1[i - 1] == chars2[j - 1] ? dp[i - 1][j - 1] + 1
                            : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int val = dp[chars1.length][chars2.length];
        return chars1.length - val + chars2.length - val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        long a = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s.minDistance("asdfghjkl", "qazxswedcvfrtgbnhyujm");
        }
        long b = System.currentTimeMillis();

        long c = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s.minDistance2("asdfghjkl", "qazxswedcvfrtgbnhyujm");
        }
        long d = System.currentTimeMillis();

        System.out.println(b - a);
        System.out.println(d - c);
    }
}
