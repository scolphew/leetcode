package lsf._349_IntersectionofTwoArrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1)
            set.add(i);
        for (int i : nums2) {
            if (set.contains(i)) {
                set2.add(i);
            }
        }
        int[] ans = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            ans[index++] = i;
        }
        return ans;
    }

}
