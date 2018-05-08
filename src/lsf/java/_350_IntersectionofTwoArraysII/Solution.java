package lsf.java._350_IntersectionofTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (int i : nums2) {
            if (map.containsKey(i)) {
                int tmp = map.get(i);
                if (tmp == 1)
                    map.remove(i);
                else
                    map.put(i, tmp - 1);
                list.add(i);
            }
        }
        int ans[] = new int[list.size()];
        int index = 0;
        for (int i : list)
            ans[index++] = i;
        return ans;
    }

    public static void main(String[] args) {
        for (int i : new Solution().intersect(
                new int[]{1},
                new int[]{1, 1})) {
            System.out.println(i);
        }
    }
}
