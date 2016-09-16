package lsf._032_LongestValidParentheses;

import java.util.Stack;

/**
 * 找到最长的合法括号序列
 *
 * @author scolphew
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;
        int max = 0;
        int left = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty())
                        max = Math.max(max, i - left);
                    else
                        max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(4 + "  " + s.longestValidParentheses("((())"));
        System.out.println(2 + "  " + s.longestValidParentheses("(()"));
        System.out.println(2 + "  " + s.longestValidParentheses("())"));
        System.out.println(4 + "  " + s.longestValidParentheses(")()())"));
        System.out.println(2 + "  " + s.longestValidParentheses("()(()"));
        System.out.println(2 + "  " + s.longestValidParentheses("(()(((()"));
        System.out.println(4 + "  " + s.longestValidParentheses("(()(((()()"));
        System.out.println(4 + "  " + s.longestValidParentheses("(()()(((()"));
        System.out.println(12 + "  " + s.longestValidParentheses("(((())))))(((((())))))"));
    }
}
