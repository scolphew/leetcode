package lsf._446_ArithmeticSlicesIISubsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                int d = (int) diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.numberOfArithmeticSlices(new int[]{0, 1, 2, 2, 2}));
        System.out.println(s.numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296}));
        System.out.println(s.numberOfArithmeticSlices(new int[]{1, 1, 1, 1}));
    }
}
