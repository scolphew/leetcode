package lsf.java._04_._455_AssignCookies;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j])
                i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(
                new int[]{10, 9, 8, 7},
                new int[]{6, 5, 7, 8}
        ));
    }

}
