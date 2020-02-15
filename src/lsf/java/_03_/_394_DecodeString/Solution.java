package lsf.java._03_._394_DecodeString;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> times = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {//数字
                int count = 0;
                while (c >= '0' && c <= '9') {
                    count = count * 10 + c - '0';
                    c = chars[++i];
                }
                times.add(count);
            } else if (c == '[') {
                stack.push(sb);
                sb = new StringBuilder();
                i++;
            } else if (c == ']') {
                StringBuilder tmp = stack.pop();
                int count = times.pop();
                for (int j = 0; j < count; j++) {
                    tmp.append(sb);
                }
                sb = tmp;
                i++;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }

}
