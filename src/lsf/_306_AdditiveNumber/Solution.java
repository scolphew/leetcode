package lsf._306_AdditiveNumber;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        char[] s = num.toCharArray();
        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                long a = str2Long(num.substring(0, i));
                long b = str2Long(num.substring(i, j));
                if (a != -1 && b != -1 && foo(s, a, b, j))
                    return true;
            }
        }
        return false;
    }

    boolean foo(char[] s, long a, long b, int start) {
        if (s.length <= start)
            return true;
        if (s[start] == '0' && (a != 0 || b != 0))
            return false;

        long tmp = 0;
        for (int i = start; i < s.length; i++) {
            tmp = tmp * 10 + s[i] - '0';
            if (tmp == a + b) {
                return foo(s, b, a + b, i + 1);
            } else if (tmp > a + b) {
                return false;
            }
        }
        return false;
    }

    public long str2Long(String s) {
        if (!s.equals("0") && s.charAt(0) == '0')
            return -1;
        return Long.parseLong(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("11112233"));
        System.out.println(new Solution().isAdditiveNumber("000"));
    }

}
