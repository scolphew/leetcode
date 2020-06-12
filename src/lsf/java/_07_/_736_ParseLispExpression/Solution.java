package lsf.java._07_._736_ParseLispExpression;

import java.util.*;

public class Solution {

    public int evaluate(String expression) {
        char[] chars = expression.toCharArray();
        StringBuilder sb;
        String tmp;

        Stack<List<String>> stack = new Stack<>();
        Stack<Map<String, Integer>> vStack = new Stack<>();

        stack.add(new ArrayList<>());
        stack.peek().add("let");


        int i = 0;
        while (i < chars.length) {
            if (chars[i] == '(') {                                           //左括号 新表达式
                i++;
                sb = new StringBuilder();
                // 找下一个关键字
                while (chars[i] == ' ') i++;  //排除空格
                while (chars[i] != ' ') sb.append(chars[i++]);
                tmp = sb.toString();

                stack.add(new ArrayList<>());                                //参数
                stack.peek().add(tmp);
                vStack.add(new HashMap<>());                           // 变量
            } else if (chars[i] == ')') {                                           //右括号 计算结果
                List<String> list = stack.pop();
                int ans = 0;
                if (list.get(0).equals("add")) {
                    int a = get(vStack, list.get(1));
                    int b = get(vStack, list.get(2));
                    ans = a + b;
                } else if (list.get(0).equals("mult")) {
                    int a = get(vStack, list.get(1));
                    int b = get(vStack, list.get(2));
                    ans = a * b;
                } else if (list.get(0).equals("let")) {
                    ans = get(vStack, list.get(1));
                }
                vStack.pop();
                List<String> peek = stack.peek();
                if (peek.get(0).equals("let") && peek.size() > 1) {
                    tmp = peek.remove(peek.size() - 1);
                    vStack.peek().put(tmp, ans);
                } else {
                    peek.add(Integer.toString(ans));
                }
                i++;
            } else if ((chars[i] >= '0' && chars[i] <= '9') || chars[i] == '-') {                 //数字
                sb = new StringBuilder();
                // 找下一个关键字
                while (chars[i] == ' ') i++;  //排除空格
                while (chars[i] != ' ' && chars[i] != ')') sb.append(chars[i++]);

                if (stack.peek().get(0).equals("let") && stack.peek().size() > 1) {                        //对于let中遇到数字，为赋值
                    List<String> peek = stack.peek();
                    tmp = peek.remove(peek.size() - 1);
                    vStack.peek().put(tmp, Integer.parseInt(sb.toString()));
                } else {
                    tmp = sb.toString();
                    stack.peek().add(tmp);
                }

            } else if (chars[i] == ' ') {
                i++;
            } else {                                                          //let 定义
                // 变量名
                sb = new StringBuilder();
                // 找下一个关键字
                while (chars[i] == ' ') i++;  //排除空格
                while (chars[i] != ' ' && chars[i] != ')') sb.append(chars[i++]);

                if (stack.peek().get(0).equals("let") && stack.peek().size() > 1) {                        //对于let中遇到数字，为赋值
                    List<String> peek = stack.peek();
                    tmp = peek.remove(peek.size() - 1);
                    vStack.peek().put(tmp, get(vStack,sb.toString()));
                } else {
                    tmp = sb.toString();
                    stack.peek().add(tmp);
                }
            }
        }
        return Integer.parseInt(stack.peek().get(1));
    }

    private int get(Stack<Map<String, Integer>> stack, String s) {
        char c = s.charAt(0);
        if (c == '-' || (c >= '0' && c <= '9')) {
            return Integer.parseInt(s);
        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (stack.get(i).containsKey(s))
                return stack.get(i).get(s);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        //System.out.println(s.evaluate("(add 2 2)"));
        //System.out.println(s.evaluate("( let x 2 ( add ( add y 5) 3 ) )"));
        //System.out.println(s.evaluate("(let x 2 8)"));

        System.out.println(s.evaluate("(let x -2 y x y)"));
        System.out.println(s.evaluate("(add 1 2)"));
        System.out.println(s.evaluate("(mult 3 (add 2 3))"));
        System.out.println(s.evaluate("(let x 2 (mult x 5))"));
        System.out.println(s.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        System.out.println(s.evaluate("(let x 3 x 2 x)"));
        System.out.println(s.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
        System.out.println(s.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
        System.out.println(s.evaluate("(let a1 3 b2 (add a1 1) b2) "));

    }
}
