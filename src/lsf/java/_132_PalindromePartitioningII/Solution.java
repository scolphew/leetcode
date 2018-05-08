package lsf.java._132_PalindromePartitioningII;

public class Solution {

    /**
     * 将s分割为回文串，求最少的切割次数
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        int cut[] = new int[n];
        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 3 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCut("aab"));
    }

}
