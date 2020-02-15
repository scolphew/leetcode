package lsf.java._05_._564_FindtheClosestPalindrome;

public class Solution {
    public String nearestPalindromic(String n) {
        char[] chars_n = n.toCharArray();
        if (n.length() >= 2 && foo1(chars_n))
            return String.valueOf(Long.parseLong(n) + 2);

        boolean isOdd = (n.length() % 2) != 0;
        String left = n.substring(0, (n.length() + 1) / 2);
        long[] increment = {-1, 0, +1};
        String ret = n;
        long minDiff = Long.MAX_VALUE;
        for (long i : increment) {
            String s = getPalindrom(Long.toString(Long.parseLong(left) + i), isOdd);
            if (n.length() >= 2 && (s.length() != n.length() || Long.parseLong(s) == 0)) {
                s = "";
                for (int j = 0; j < n.length() - 1; j++) {
                    s += "9";
                }
            }
            long diff = s.equals(n) ? Long.MAX_VALUE : Math.abs(Long.parseLong(s) - Long.parseLong(n));
            if (diff < minDiff) {
                minDiff = diff;
                ret = s;
            }
        }
        return ret;
    }

    private String getPalindrom(String s, boolean isOdd) {
        String right = new StringBuilder(s).reverse().toString();
        return isOdd ? s.substring(0, s.length() - 1) + right : s + right;
    }


    public boolean foo1(char[] n) {
        for (char c : n)
            if (c != '9')
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nearestPalindromic("10101"));
    }
}
