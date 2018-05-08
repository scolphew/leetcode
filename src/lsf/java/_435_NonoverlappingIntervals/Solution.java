package lsf.java._435_NonoverlappingIntervals;

import base.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 2)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end == o2.end ? o2.start - o1.start : o1.end - o2.end;
            }
        });

        int end = intervals[0].end;
        int ans = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end)
                ans++;
            else {
                end = intervals[i].end;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().eraseOverlapIntervals(new Interval[]{
                new Interval(1, 5),
                new Interval(2, 3),
                new Interval(3, 4),
        }));
    }
}
