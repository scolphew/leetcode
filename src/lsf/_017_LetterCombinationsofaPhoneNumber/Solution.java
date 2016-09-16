package lsf._017_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话键盘上几个数字可能出现的所有字符串组合
 * @author scolphew
 */
public class Solution {

    String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0)
            return list;

        letterCombinations(digits, 0, list);
        return list;
    }

    public void letterCombinations(String digits, int len, List<String> list) {
        if (len == digits.length()) {
            list.add(sb.toString());
            return;
        } else {
            for (int i = 0; i < keys[digits.charAt(len) - '0'].length(); i++) {
                sb.append(keys[digits.charAt(len) - '0'].charAt(i));
                letterCombinations(digits, len + 1, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("233"));
    }
}
