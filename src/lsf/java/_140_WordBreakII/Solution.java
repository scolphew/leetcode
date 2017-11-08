package lsf.java._140_WordBreakII;

import java.util.*;

public class Solution {
    /**
     * 求wordDoct中的单词能否组成s
     * 输出所有的组成方式
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (wordDict == null || wordDict.size() == 0) {
            return res;
        }
        Set<String> set = new HashSet<>(wordDict);
        List<Integer>[] dp = new List[s.length() + 1];

        dp[0] = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != null && set.contains(s.substring(j, i))) {
                    if (dp[i] == null) {
                        dp[i] = new ArrayList<>();
                    }
                    dp[i].add(j);
                }
            }
        }

        if (dp[s.length()] == null) {
            return res;
        }

        List<StringBuilder> list = foo(dp, s.length(), s);
        for (StringBuilder sb : list) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }
        return res;
    }


    public List<StringBuilder> foo(List<Integer>[] dp, int n, String s) {
        List<StringBuilder> res = new ArrayList<>();
        for (int i : dp[n]) {
            String tmp = s.substring(i, n);
            List<StringBuilder> list = foo(dp, i, s);
            if (list.size() > 0) {
                for (StringBuilder sb : list) {
                    sb.append(tmp);
                    sb.append(" ");
                    res.add(sb);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(tmp);
                sb.append(" ");
                res.add(sb);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.wordBreak("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"})));
        System.out.println(s.wordBreak("a", Arrays.asList(new String[]{})));
    }
}
