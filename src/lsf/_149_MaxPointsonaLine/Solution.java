package lsf._149_MaxPointsonaLine;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            return String.format("【%d,%d】", x, y);
        }
    }

    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>() {
            @Override
            public Map<Integer, Integer> get(Object key) {
                if (!containsKey(key)) {
                    put((Integer) key, new HashMap<>());
                }
                return super.get(key);
            }

        };
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                if (x == 0)
                    y = 1;
                if (y == 0)
                    x = 1;
                if (x != 0 && y != 0) {
                    int gcd = generateGCD(x, y);
                    x /= gcd;
                    y /= gcd;
                }
                map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int generateGCD(int a, int b) {
        if (b == 0) return a;
        if (a == 0) return b;
        while (b != 1) {
            if (a % b == 0) return b;
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Point[] points = new Point[4];
        points[0] = new Point(1, 1);
        points[2] = new Point(2, 2);

        points[1] = new Point(1, 2);
        points[3] = new Point(2, 3);
        System.out.println(s.maxPoints(points));
        System.out.println(s.generateGCD(1, 3));
        System.out.println(s.generateGCD(3, 1));
        //System.out.println(s.generateGCD(1, 7));
        //System.out.println(s.generateGCD(12, 18));


    }

}
