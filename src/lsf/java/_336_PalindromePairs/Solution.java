package lsf.java._336_PalindromePairs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * TLE
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && foo(words[i], words[j])) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public boolean foo(String a, String b) {
        int l1 = a.length(), l2 = b.length();
        if (l1 > l2) {
            for (int i = 0; i < l2; i++) {
                if (a.charAt(i) != b.charAt(l2 - 1 - i)) return false;
            }
            l1--;
            while (l2 < l1) {
                if (a.charAt(l2++) != a.charAt(l1--)) return false;
            }
            return true;
        } else {
            for (int i = 0; i < l1; i++) {
                if (a.charAt(i) != b.charAt(l2 - 1 - i)) return false;
            }
            l2 -= l1 + 1;
            l1 = 0;
            while (l1<l2){
                if (b.charAt(l1++) != b.charAt(l2--)) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().palindromePairs(new String[]{
                "abcdd", "cba", "ad", "ssda"
        }));
    }

}
