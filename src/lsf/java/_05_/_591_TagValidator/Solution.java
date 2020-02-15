package lsf.java._05_._591_TagValidator;

import java.util.Stack;

public class Solution {

    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < code.length(); ) {
            if (i > 0 && stack.isEmpty())
                return false;
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0)
                    return false;
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf('>', j);
                if (i < 0 || i == j || i - j > 9)
                    return false;
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(s))
                    return false;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf('>', j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                stack.push(s);
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("<A><A>/A></A></A>"));
        System.out.println(s.isValid("<DIV>This is the first line <![CDATA[<DIV>]]></DIV>"));
        System.out.println(s.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        System.out.println(s.isValid("<A>  <B> </A>   </B>"));
        System.out.println(s.isValid("<DIV>  div tag is not closed  <DIV>"));
    }

}
