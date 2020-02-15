package lsf.java._03_._395_LongestSubstringwithAtLeastKRepeatingCharacters;

public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }

    private int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[str[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) {
                for (int j = start; j < end; j++) {
                    if (str[j] == i + 'a') {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().longestSubstring("aaabb", 3));
    }
}
