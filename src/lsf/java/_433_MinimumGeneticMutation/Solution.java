package lsf.java._433_MinimumGeneticMutation;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            if (s.length() != end.length())
                return -1;
            set.add(s);
        }
        return minMutation(start, end, set);
    }

    public int minMutation(String start, String end, Set<String> set) {
        if (start.equals(end)) {
            return 0;
        }
        if (!set.contains(end)) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        for (String s : new HashSet<>(set)) {
            if (foo(start, s) == 1) {
                set.remove(s);
                int tmp = minMutation(s, end, set);
                if (tmp != -1)
                    ans = Math.min(ans, tmp + 1);
                set.add(s);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int foo(String s1, String s2) {
        int ans = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMutation("AACCGGTT",
                "AAACGGTA",
                new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }

}
