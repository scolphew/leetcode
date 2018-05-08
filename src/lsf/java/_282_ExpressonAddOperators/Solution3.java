package lsf.java._282_ExpressonAddOperators;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= num.length(); i++) {
            if (i > 1 && num.charAt(0) == '0')
                break;
            foo(ans, num.substring(0, i), num.substring(i), target, 0, Long.parseLong(num.substring(0, i)), true);

        }
        return ans;
    }


    public void foo(List<String> ans, String s1, String s2, int target, long a1, long a2, boolean sign) {
        long sum = sign ? a1 + a2 : a1 - a2;
        if (s2.length() == 0) {
            if (sum == target)
                ans.add(s1);
            return;
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (i > 1 && s2.charAt(0) == '0')
                break;
            long tmp = Long.parseLong(s2.substring(0, i));
            foo(ans, s1 + "+" + tmp, s2.substring(i), target, sum, tmp, true);
            foo(ans, s1 + "-" + tmp, s2.substring(i), target, sum, tmp, false);
            foo(ans, s1 + "*" + tmp, s2.substring(i), target, a1, a2 * tmp, sign);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().addOperators("123", 6));
        System.out.println(new Solution3().addOperators("105", 5));
    }
}
