package lsf.java._07_._767_ReorganizeString;

import java.util.Arrays;

public class Solution {

    public String reorganizeString(String S) {
        final int[] count = new int[26];
        final int L = S.length();
        final char[] ans = new char[L];
        for (char c : S.toCharArray()) {
            count[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            count[i] += i;
        }
        Arrays.sort(count);
        if (count[25] / 100 > (L + 1) / 2) return "";

        int index = 0;
        for (int i = 25; i >= 0; i--) {
            final char c = (char) (count[i] % 100 + 'a');
            for (int j = 0; j < count[i] / 100; j++) {
                if (index >= L) index = 1;
                ans[index] = c;
                index += 2;
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reorganizeString("aaabb"));
        System.out.println(s.reorganizeString("abbabbaaab"));
    }

}
