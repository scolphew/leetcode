package lsf._336_PalindromePairs;

import java.util.*;

public class Solution2 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<>();
        if (words.length < 2)
            return ans;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String tmp = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(tmp) && map.get(tmp) != i) {
                        ans.add(Arrays.asList(map.get(tmp), i));
                    }
                }
                if (isPalindrome(s2)) {
                    String tmp = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(tmp) && map.get(tmp) != i && s2.length() != 0) {
                        ans.add(Arrays.asList(i, map.get(tmp)));
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().palindromePairs(new String[]{
                "abcd", "dcba", "lls", "s", "sssll"
        }));
    }

}
