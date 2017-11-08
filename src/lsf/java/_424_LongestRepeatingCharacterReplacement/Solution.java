package lsf.java._424_LongestRepeatingCharacterReplacement;

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int srart = 0, max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            int countC = ++counts[c];
            if (countC > count) count = countC;
            while (i - srart + 1 - count > k) {
                counts[s.charAt(srart) - 'A']--;
                srart++;
            }
            max = Math.max(i - srart + 1, max);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("AABABBA", 1));
    }
}
