package lsf.java._04_._403_FrogJump;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 1) return true;
        if (stones[1] != 1) return false;
        if (stones.length == 2) return true;
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < stones.length; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) {
                return false;
            }
            hs.add(stones[i]);
        }
        return foo(hs, 1, 1, stones[stones.length - 1]);
    }

    private boolean foo(Set<Integer> hasStone, int start, int lastSterp, int last) {
        if (start + lastSterp - 1 == last || start + lastSterp == last || start + lastSterp + 1 == last)
            return true;
        if (hasStone.contains(start + lastSterp + 1) && foo(hasStone, start + lastSterp + 1, lastSterp + 1, last))
            return true;
        if (hasStone.contains(start + lastSterp) && foo(hasStone, start + lastSterp, lastSterp, last))
            return true;
        if (lastSterp > 1 && hasStone.contains(start + lastSterp - 1) && foo(hasStone, start + lastSterp - 1, lastSterp - 1, last))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canCross(new int[]{0, 1, 3, 6, 10, 15, 19, 21, 24, 26, 30, 33}));
    }
}
