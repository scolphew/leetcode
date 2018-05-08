package base;

import base.error.ValueError;
import lsf.java._215_KthLargestElementinanArray.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Base {

    /**
     * 最大公约数，
     *
     * @param a 非零
     * @param b 非零
     * @return 最大公约数
     */
    public static int gcd(int a, int b) {
        while (b != 1) {
            if (a % b == 0) return b;
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    /**
     * 最大公约数，若有一个为0，返回另一个
     *
     * @param a 可为零
     * @param b 可为零
     * @return 最大公约数，或非零的一个参数
     */
    public static int gcd2(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd(a, b);
    }


    /**
     * 寻找数组中第i大的数
     *
     * @param nums
     * @param i
     * @return
     */
    public static int findNTh(int[] nums, int i) {
        return new Solution().findKthLargest(nums, i);
    }

    public static int eval(String string) {
        List<String> list = infixExpToPostExp(string);
        return doEval(list);
    }

    private static int doEval(List<String> list) {
        Stack<Object> stack = new Stack<>();
        String element;
        int n1, n2, result;
        for (String s : list) {
            if (isOperator(s)) {
                n1 = (Integer) stack.pop();
                n2 = (Integer) stack.pop();
                stack.push(operate(n2, n1, s));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return (int) stack.pop();
    }

    private static int operate(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }

    private static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    /**
     * 将中缀表达式转换为后缀表达式
     *
     * @param exp 中缀表达式
     * @return 后缀表达式
     */
    public static List<String> infixExpToPostExp(String exp) {
        exp = exp + "#";
        List<String> postExp = new ArrayList<>();//存放后缀表达式
        StringBuilder numBuffer = new StringBuilder();//用来保存一个数
        Stack<Character> opStack = new Stack<>();//操作数栈

        char ch, preCh;
        opStack.push('#');
        for (int i = 0; i < exp.length(); ) {
            ch = exp.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    preCh = opStack.peek();
                    while (priority(preCh) >= priority(ch)) {
                        postExp.add("" + preCh);
                        opStack.pop();
                        preCh = opStack.peek();
                    }
                    opStack.push(ch);
                    i++;
                    break;
                case '(':
                    opStack.push(ch);
                    i++;
                    break;
                case ')':
                    char c = opStack.pop();
                    while (c != '(') {
                        postExp.add("" + c);
                        c = opStack.pop();
                    }
                    i++;
                    break;
                case '#':
                    char c1;
                    while (!opStack.isEmpty()) {
                        c1 = opStack.pop();
                        if (c1 != '#')
                            postExp.add("" + c1);
                    }
                    i++;
                    break;
                case ' ':
                case '\t':
                    i++;
                    break;
                default:
                    if (Character.isDigit(ch)) {
                        while (Character.isDigit(ch)) {
                            numBuffer.append(ch);
                            ch = exp.charAt(++i);
                        }
                        postExp.add(numBuffer.toString());
                        numBuffer.delete(0, numBuffer.length());
                    } else {
                        throw new ValueError("错误的输入");
                    }
            }
        }

        return postExp;
    }

    /**
     * 操作优先级
     *
     * @param op 操作
     * @return 优先级
     */
    private static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case '#':
                return 0;
            default:
                throw new ValueError("未定义该操作符，需要检查输入");
        }
    }

    public static void main(String[] args) {
        System.out.println(eval("3+5*(2/5)+4/2-5*7"));

    }
}
