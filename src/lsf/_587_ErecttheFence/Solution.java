package lsf._587_ErecttheFence;


import base.Point;

import java.util.*;

public class Solution {
    public List<Point> outerTrees(Point[] points) {
        Arrays.sort(points, (a, b) -> ((a.x == b.x) ? (a.y - b.y) : (a.x - b.x)));
        List<Point> list1 = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            list1.add(points[i]);
            int size;
            while ((size = list1.size()) >= 3 && sign(list1.get(size - 3), list1.get(size - 2), list1.get(size - 1)) < 0) {
                list1.remove(size - 2);
            }
        }
        List<Point> list2 = new ArrayList<>();
        for (int i = points.length - 1; i >= 0; i--) {
            list1.add(points[i]);
            int size;
            while ((size = list1.size()) >= 3 && sign(list1.get(size - 3), list1.get(size - 2), list1.get(size - 1)) < 0) {
                list1.remove(size - 2);
            }
        }
        Set<Point> set = new HashSet<>();
        for (Point p : list1)
            set.add(p);
        for (Point p : list2)
            set.add(p);
        return new ArrayList<>(set);
    }

    /**
     * 三个点的方向，
     *
     * @return =0:共线  >:逆时针  <0:顺时针
     */
    private int sign(Point p, Point q, Point r) {
        return (p.x - r.x) * (q.y - r.y) - (p.y - r.y) * (q.x - r.x);
    }
}
