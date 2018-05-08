package lsf.java._391_PerfectRectangle;

import java.util.HashSet;

public class Solution {
    /**
     * 输入为二维数组，每个一维数组表示两个坐标，代表矩形区域（坐下右上两个点）
     * 求给出的所有矩形区域能够组成矩形。（不能重合,或缺失）
     */
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0)
            return false;
        int area = 0;
        int b_l_x = Integer.MAX_VALUE, b_l_y = Integer.MAX_VALUE;
        int t_r_x = Integer.MIN_VALUE, t_r_y = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] x : rectangles) {
            b_l_x = Math.min(b_l_x, x[0]);
            b_l_y = Math.min(b_l_y, x[1]);
            t_r_x = Math.max(t_r_x, x[2]);
            t_r_y = Math.max(t_r_y, x[3]);
            area += (x[2] - x[0]) * (x[3] - x[1]);

            String b_l = x[0] + "," + x[1];
            String b_r = x[2] + "," + x[1];
            String t_l = x[0] + "," + x[3];
            String t_r = x[2] + "," + x[3];
            if (set.contains(b_l)) set.remove(b_l);
            else set.add(b_l);
            if (set.contains(b_r)) set.remove(b_r);
            else set.add(b_r);
            if (set.contains(t_l)) set.remove(t_l);
            else set.add(t_l);
            if (set.contains(t_r)) set.remove(t_r);
            else set.add(t_r);
        }

        return set.contains(b_l_x + "," + b_l_y) && set.contains(b_l_x + "," + t_r_y)
                && set.contains(t_r_x + "," + b_l_y) && set.contains(t_r_x + "," + t_r_y)
                && (set.size() == 4)
                && (area == ((t_r_x - b_l_x) * (t_r_y - b_l_y)));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isRectangleCover(new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        }));
    }
}
