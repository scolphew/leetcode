package lsf.java._01_._128_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        for (int i : nums) {
            int count = 1;
            int num = i;
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }
            num = i;
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestConsecutive(new int[]{5, 4, 1, 2, 3, 8, 9}));
    }
}
