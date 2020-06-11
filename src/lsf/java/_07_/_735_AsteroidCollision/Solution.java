package lsf.java._07_._735_AsteroidCollision;

import base.Print;

import java.util.Stack;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(i);
            } else if (stack.peek() > 0 && i > 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() < 0) {  //同左
                        stack.push(i);
                        break;
                    } else if (stack.peek() + i < 0) {  //向左撞掉
                        stack.pop();
                        if(stack.isEmpty()){
                            stack.push(i);
                            break;
                        }
                        continue;
                    } else if (stack.peek() + i == 0) {  //同装
                        stack.pop();
                        break;
                    } else {                        //向左 撞不动
                        break;
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Print.print(s.asteroidCollision(new int[]{-5, 10, 5, -4, 2, 4, 5, 6, -3, 5, -23, 23}));
        Print.print(s.asteroidCollision(new int[]{1, -2, -2, -2}));
    }

}
