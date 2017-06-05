package lsf._415_AddStrings;

public class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.max(len1, len2) + 1;
        char[] s = new char[len];

        int tmp = 0;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        for (int i = 0; i < len1 && i < len2; i++) {
            int x = chars1[len1 - i - 1] - '0';
            int y = chars2[len2 - i - 1] - '0';
            int sum = x + y + tmp;
            s[len - 1 - i] = (char) (sum % 10 + '0');
            tmp = (sum / 10);
        }
        if (len1 == len2) {
            s[0] = (char) (tmp + '0');
        } else if (len1 > len2) {
            foo(s, chars1, len2, tmp);
        } else {
            foo(s, chars2, len1, tmp);
        }
        return new String(s, s[0] == '0' ? 1 : 0, s[0] == '0' ? len - 1 : len);

    }

    private void foo(char[] s, char[] num, int start, int tmp) {
        for (int i = start; i < num.length; i++) {
            int x = num[num.length - i - 1] - '0';
            int sum = x + tmp;
            s[s.length - 1 - i] = (char) (sum % 10 + '0');
            tmp = (sum / 10);
        }
        s[0] = (char) (tmp + '0');
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("123", "556"));
        System.out.println(new Solution().addStrings("623", "556"));
        System.out.println(new Solution().addStrings("111", "1"));
        System.out.println(new Solution().addStrings("9999", "1"));
        System.out.println(new Solution().addStrings("1", "9999"));
    }
}
