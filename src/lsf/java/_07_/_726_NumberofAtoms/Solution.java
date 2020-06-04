package lsf.java._07_._726_NumberofAtoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {

    public String countOfAtoms(String formula) {
        Map<String, Integer> ans = new HashMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(ans);
        StringBuilder sb;

        char[] chars = formula.toCharArray();
        int i = 0;
        int n;
        while (i < chars.length) {
            if (chars[i] == '(') {                          // 进入括号
                stack.push(new HashMap<>());
                i++;
            } else if (chars[i] == ')') {                   // 结束括号
                Map<String, Integer> pop = stack.pop();
                Map<String, Integer> peek = stack.peek();
                i++;
                n = 0;
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                    n = n * 10 + chars[i++] - '0';
                }
                n = (n == 0) ? 1 : n;
                for (Map.Entry<String, Integer> entry : pop.entrySet()) {
                    String k = entry.getKey();
                    Integer v = entry.getValue();
                    peek.put(k, peek.getOrDefault(k, 0) + v * n);
                }
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {          // 新元素
                sb = new StringBuilder();
                sb.append(chars[i++]);
                while (i < chars.length && chars[i] >= 'a' && chars[i] <= 'z') {
                    sb.append(chars[i++]);
                }
                String tmp = sb.toString();
                n = 0;
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                    n = n * 10 + chars[i++] - '0';
                }
                n = (n == 0) ? 1 : n;
                Map<String, Integer> peek = stack.peek();
                peek.put(tmp, peek.getOrDefault(tmp, 0) + n);
            }
        }
        ans = new TreeMap<>(ans);
        sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : ans.entrySet()) {
            sb.append(entry.getKey());
            n = entry.getValue();
            sb.append(n == 1 ? "" : n);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countOfAtoms("(H2O)3((H2O2)3Mg)4"));
        System.out.println(s.countOfAtoms("H2O"));
        System.out.println(s.countOfAtoms("Mg(OH)2"));
        System.out.println(s.countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(s.countOfAtoms("H11He49NO35B7N46Li20"));
        System.out.println(s.countOfAtoms("(Cm39)5(Ga28Sb45Rb8)20(Bk13Fr29As)45"));
    }

}
