package lsf.java._07_._738_MonotoneIncreasingDigits;

public class Solution {

    public int monotoneIncreasingDigits(int N) {
        char[] chars = Integer.toString(N).toCharArray();

        int i = 0;
        while (i < chars.length - 1 && chars[i] <= chars[i + 1])
            i++;
        while (i >= 0 && i < chars.length - 1 && chars[i] > chars[i + 1])
            chars[i--]--;
        for (i = i + 2; i < chars.length; i++)
            chars[i] = '9';
        int ans = 0;
        for (int j = 0; j < chars.length; j++) {
            ans = ans * 10 + chars[j] - '0';
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.monotoneIncreasingDigits(12332));
        System.out.println(s.monotoneIncreasingDigits(122345));
    }

}
