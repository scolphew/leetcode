package lsf._022_GenerateParentheses;

import lsf._000_base.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * 给数字n
 * 给出所有可能的n个括号对
 * @author scolphew
 */
public class Solution {
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        sb.append('(');
        generateParenthesis(list, n, 1, 0);

        return list;
    }

    void generateParenthesis(List list, int n, int left, int right) {
        if (right == n) {
            list.add(sb.toString());
            return;
        }
        if (left < n) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    sb.append('(');
                    generateParenthesis(list, n, left + 1, right);
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    if (left > right) {
                        sb.append(')');
                        generateParenthesis(list, n, left, right + 1);
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        } else {
            sb.append(')');
            generateParenthesis(list, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List list = s.generateParenthesis(3);
        Print.printlnList(list);
    }
}
