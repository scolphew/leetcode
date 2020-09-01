package lsf.java._07_._777_SwapAdjacentinLRString;

public class Solution {

    public boolean canTransform(String start, String end) {
        int N = start.length();
        char[] S = start.toCharArray(), T = end.toCharArray();
        int i = 0, j = 0;
        while (i < N || j < N) {
            while (i < N && S[i] == 'X') i++;
            while (j < N && T[j] == 'X') j++;

            if ((i < N) ^ (j < N))
                return false;

            if (i < N && j < N) {
                if (S[i] != T[j] || (S[i] == 'L' && i < j) ||
                        (S[i] == 'R' && i > j))
                    return false;
            }
            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canTransform("XXRXLXRXXX", "XXRLXXXXXR"));
        System.out.println(s.canTransform("XXXLXXXXXX", "XXXLXXXXXX"));
    }
}

