package lsf.java._02_._227_BasicCalculatorII;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {

        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> op = new LinkedList<>();
        int tmp = 0, i = 0;
        char c[] = s.toCharArray();
        while (i < c.length) {
            if (c[i] >= '0' && c[i] <= '9') {
                tmp = 0;
                while (i < c.length && c[i] >= '0' && c[i] <= '9') {
                    tmp = tmp * 10 + c[i] - '0';
                    i++;
                }
                numStack.offer(tmp);
            } else if (c[i] == '+' | c[i] == '-') {
                op.offer(c[i]);
                i++;
                tmp = 0;
                while (c[i] == ' ') {
                    i++;
                }
                while (i < c.length && c[i] >= '0' && c[i] <= '9') {
                    tmp = tmp * 10 + c[i] - '0';
                    i++;
                }
                numStack.offer(tmp);
            } else if (c[i] == '*') {
                i++;
                tmp = 0;
                while (c[i] == ' ') {
                    i++;
                }
                while (i < c.length && c[i] >= '0' && c[i] <= '9') {
                    tmp = tmp * 10 + c[i] - '0';
                    i++;
                }
                numStack.offer(numStack.pollLast() * tmp);
            } else if (c[i] == '/') {
                i++;
                tmp = 0;
                while (c[i] == ' ') {
                    i++;
                }
                while (i < c.length && c[i] >= '0' && c[i] <= '9') {
                    tmp = tmp * 10 + c[i] - '0';
                    i++;
                }
                numStack.offer(numStack.pollLast() / tmp);
            } else {
                ++i;
            }
        }
        int res = numStack.poll();
        while (!op.isEmpty()) {
            char ch = op.poll();
            int a = numStack.poll();
            switch (ch) {
                case '+':
                    res += a;
                    break;
                case '-':
                    res -= a;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1+2*6+3/2"));
        System.out.println(new Solution().calculate("30"));
        System.out.println(new Solution().calculate("3 + 5 / 2"));
        System.out.println(new Solution().calculate("1-1+1"));
    }
}
