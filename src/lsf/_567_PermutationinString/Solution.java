package lsf._567_PermutationinString;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2)
            return false;
        int a = 0;
        for (int i = 0; i < l1; i++) {
            a += 1 << (s1.charAt(i) - 'a');
            a -= 1 << (s2.charAt(i) - 'a');
        }
        for (int i = l1; i < l2; i++) {
            if (a == 0)
                return true;
            a += 1 << (s2.charAt(i - l1) - 'a');
            a -= 1 << (s2.charAt(i) - 'a');
        }
        return a == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkInclusion("aaa", "aabaaa"));
    }


}
