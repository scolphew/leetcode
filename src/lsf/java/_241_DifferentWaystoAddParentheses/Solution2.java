package lsf.java._241_DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<>();
        List<Character> op = new ArrayList<>();
        char[] s = input.toCharArray();
        int tmp = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == '+' || c == '-' || c == '*') {
                nums.add(tmp);
                op.add(c);
                tmp = 0;
            } else {
                tmp = tmp * 10 + c - '0';
            }
        }
        nums.add(tmp);
        List<Integer>[][] dp = new List[nums.size()][nums.size()];
        return foo(nums, op, dp, 0, nums.size() - 1);
    }


    public List<Integer> foo(List<Integer> nums, List<Character> op, List<Integer>[][] dp, int start, int end) {
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        List<Integer> ans = new ArrayList<>();
        if (start == end) {
            ans.add(nums.get(start));
            dp[start][end] = ans;
            return ans;
        }
        for (int i = start; i < end; i++)
            for (int x : foo(nums, op, dp, start, i))
                for (int y : foo(nums, op, dp, i + 1, end))
                    if (op.get(i) == '+') ans.add(x + y);
                    else if (op.get(i) == '-') ans.add(x - y);
                    else if (op.get(i) == '*') ans.add(x * y);
        dp[start][end] = ans;
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Solution2().diffWaysToCompute("2*3-4*5"));
    }

}
