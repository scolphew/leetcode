package lsf.java._402_RemoveKDigits;

public class Solution {
    public String removeKdigits(String num, int k) {
        k = num.length() - k;
        if (k == 0)
            return "0";
        int n = num.length();
        char[] ans = new char[k];
        char[] chars = num.toCharArray();
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i > k - j && j > 0 && ans[j - 1] > chars[i])
                j--;
            if (j < k)
                ans[j++] = chars[i];
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < k && ans[i] == '0')
            i++;
        for (; i < k; i++)
            sb.append(ans[i]);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeKdigits("1432219", 3));
        System.out.println(s.removeKdigits("112", 1));
        System.out.println(s.removeKdigits("5337", 2));
        System.out.println(s.removeKdigits("12345", 3));
        System.out.println(s.removeKdigits("10200", 1));
        System.out.println(s.removeKdigits("10", 2));
    }

}
