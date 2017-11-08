package lsf.java._436_FindRightInterval;

import base.Interval;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    /**
     * 求在所有区间右边最近的区间的序号
     * 每个start最多一个区间
     * 所有的区间都符合条件
     * j在i右边==j.start>=i.end
     *
     * @param intervals
     * @return
     */
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i].start, i);
        }
        //System.out.println(map);
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = (entry == null) ? -1 : entry.getValue();
        }

        return result;
    }


    public static void main(String[] args) {
    }
}
