package lsf.java._459_RepeatedSubstringPattern;

public class Solution {

    public boolean repeatedSubstringPattern(String string) {
        char[] s = string.toCharArray();
        int n = s.length;
        int[] counts = new int[26];
        for (char c : s) {
            counts[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i : counts) {
            if (i > 0 && i < min)
                min = i;
        }
        for (int i = 2; i <= min; i++) {
            if (n % i == 0) {
                int a = 0, b = n / i;
                while (b < n) {
                    if (s[a] == s[b]) {
                        a++;
                        b++;
                    } else {
                        break;
                    }
                }
                if (a == n - n / i)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("abbaabbaabbaa"));
    }

}
