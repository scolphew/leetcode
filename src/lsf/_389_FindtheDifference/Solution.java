package lsf._389_FindtheDifference;

public class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        for (char c : t.toCharArray()) ans += c;
        for (char c : s.toCharArray()) ans -= c;
        return (char) ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("abcd", "abcde"));
    }
}
