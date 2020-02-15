package lsf.java._03_._394_DecodeString;

import java.util.Stack;

public class Solution2 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        int tmp = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                tmp = tmp * 10 + c - '0';
            } else if (c == '[') {
                counts.push(tmp);
                tmp = 0;
                stack.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder curr = stack.pop();
                int count = counts.pop();
                for (int j = 0; j < count; j++) {
                    curr.append(sb);
                }
                sb = curr;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().decodeString("3[a]2[bc]"));
        System.out.println(new Solution2().decodeString("3[a2[c]]"));
        System.out.println(new Solution2().decodeString("2[abc]3[cd]ef"));
    }

}
