package lsf.java._131_PalindromePartitioning;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        boolean[][] isPartition = new boolean[s.length()][s.length()];

        int n = s.length();
        List<List<String>>[] lists = new List[n + 1];

        lists[0] = new ArrayList<>();
        lists[0].add(new ArrayList<>());
        //lists[0].get(0).add("");

        for (int i = 1; i <= n; i++) {
            List<List<String>> tmp = new ArrayList<>();
            lists[i] = tmp;
            for (int j = i; j > 0; j--) {
                if (s.charAt(j - 1) == s.charAt(i - 1) && (i - j < 3 || isPartition[j][i - 2])) {
                    isPartition[j - 1][i - 1] = true;
                    for (List<String> lst : lists[j - 1]) {
                        List<String> l = new ArrayList<>();
                        for (String ss : lst) {
                            l.add(ss);
                        }
                        l.add(s.substring(j - 1, i));
                        tmp.add(l);
                    }
                }
            }
        }
        return lists[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.partition("a"));
        //System.out.println(s.partition(""));
        //System.out.println(s.partition("aab"));
        System.out.println(s.partition("ababa"));
    }
}
