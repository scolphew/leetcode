package lsf.java._07_._740_DeleteandEarn;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int avoid = 0, using = 0, prev = -1;


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            int m = Math.max(avoid, using);
            //if (num - 1 == prev) {
            //    using = avoid + num * count;
            //} else {
            //    using = m + num * count;
            //}
            using = ((num - 1 == prev) ? avoid : m) + num * count;
            avoid = m;
            prev = num;
        }

        return Math.max(avoid, using);
    }
}
