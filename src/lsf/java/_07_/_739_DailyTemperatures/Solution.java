package lsf.java._07_._739_DailyTemperatures;

import base.Print;

import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!s.isEmpty() && T[s.peek()] < T[i]) {
                int x = s.pop();
                ans[x] = i - x;
            }
            s.push(i);
        }
        return ans;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Print.print(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

}
