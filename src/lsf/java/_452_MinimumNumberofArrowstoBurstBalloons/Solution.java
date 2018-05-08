package lsf.java._452_MinimumNumberofArrowstoBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int ans = 1;
        int pos = points[0][1];
        for (int[] p : points) {
            if (p[0] <= pos) {
                pos = Math.min(pos, p[1]);
            } else {
                pos = p[1];
                ans++;
            }
        }
        return ans;
    }

    public int foo(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int ans = 1;
        int lastEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) {
                ans++;
                lastEnd = points[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(new Solution().findMinArrowShots(new int[][]{{-1, 1}}));
        System.out.println(new Solution().findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}));
        System.out.println(new Solution().foo(new int[][]{{8, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 97}}));
    }
}
