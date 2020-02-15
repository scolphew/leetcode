package lsf.java._03_._385_MiniParser;

import java.util.Stack;

public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = new NestedInteger();
        int sign = 1;
        int tmp = 0;
        char[] chars = s.toCharArray();
        for (int r = 1; r < s.length(); r++) {
            char ch = chars[r];
            if (ch == '[') {
                stack.push(curr);
                curr = new NestedInteger();
                tmp = 0;
                sign = 1;
            } else if (ch == ']') {
                if (chars[r - 1] >= '0' && chars[r - 1] <= '9')
                    curr.add(new NestedInteger(tmp * sign));

                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                tmp = 0;
                sign = 1;
            } else if (ch == ',') {
                if (chars[r - 1] != ']') {
                    curr.add(new NestedInteger(tmp * sign));
                }
                tmp = 0;
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else {
                tmp = tmp * 10 + chars[r] - '0';
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().deserialize("[123,[456,[789]]]"));
        System.out.println(new Solution().deserialize("[-1]"));
    }

}
