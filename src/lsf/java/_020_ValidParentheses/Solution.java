package lsf.java._020_ValidParentheses;

import java.util.Stack;

/**
 * 判断由{}[]()组成的String是否是合法的括号对
 * @author scolphew
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char pop;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty())
                return false;
            pop = stack.pop();
            switch (pop) {
                case '(':
                    if (c == ')') {
                        continue;
                    }
                    else
                        return false;
                case '[':
                    if (c == ']')
                        continue;
                    else
                        return false;
                case '{':
                    if (c == '}')
                        continue;
                    else
                        return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("[{]}"));
    }
}
