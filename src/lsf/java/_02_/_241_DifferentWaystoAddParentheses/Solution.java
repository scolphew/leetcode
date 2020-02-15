package lsf.java._02_._241_DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        char[] s = input.toCharArray();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> a = diffWaysToCompute(input.substring(0, i));
                List<Integer> b = diffWaysToCompute(input.substring(i + 1));
                for (Integer x : a) {
                    for (Integer y : b) {
                        switch (c) {
                            case '+':
                                res.add(x + y);
                                break;
                            case '-':
                                res.add(x - y);
                                break;
                            case '*':
                                res.add(x * y);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }


}
