package lsf.java._06_._682_BaseballGame;

import java.util.Stack;

public class Solution {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for (String s : ops) {
            if ("+".equals(s)) {
                int a = stack.pop();
                int b = a + stack.peek();
                stack.push(a);
                stack.push(b);
            } else if ("C".equals(s)) {
                stack.pop();
            } else if ("D".equals(s)) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        int ans = 0;
        for (int score : stack)
            ans += score;
        return ans;
    }

}
