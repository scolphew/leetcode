package lsf.java._02_._224_BasicCalculator;

import java.util.Stack;

public class Solution {
    public int calculate(String string) {
        Stack<Integer> stack = new Stack<>();
        char s[] = string.toCharArray();
        int num = 0, sign = 1, res = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                num = num * 10 + s[i] - '0';
            } else if (s[i] == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (s[i] == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (s[i] == '(') {
                stack.add(res);
                stack.add(sign);
                sign = 1;
                res = 0;
            } else if (s[i] == ')') {
                res += sign * num;
                num = 0;
                sign = 1;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        return res + sign * num;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().calculate("2+(4-5)+5"));
    }
}
