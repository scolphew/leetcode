package lsf.java._456_132Pattern;

import java.util.Stack;

public class Solution {

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else {
                while (!stack.empty()) {
                    if (stack.peek() >= num)
                        break;
                    stack.pop();
                    if (stack.pop() > num)
                        return true;
                }
                stack.push(num);
                stack.push(min);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().find132pattern(new int[]{-1, 2, 1}));
        System.out.println(new Solution().find132pattern(new int[]{1, 5, -3, 1, -2}));
    }

}
