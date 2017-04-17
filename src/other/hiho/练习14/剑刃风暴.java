package other.hiho.练习14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 剑刃风暴 {

    public static class Point {
        int x;
        int y;

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }


    public static class Seg {
        double x;
        int y;
    }


    public static double dis(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        Point[] points = new Point[n];
        Seg[] s = new Seg[2 * n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(in.nextInt(), in.nextInt());
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = new Seg();
        }
        Comparator<Seg> cmp = new Comparator<Seg>() {
            @Override
            public int compare(Seg o1, Seg o2) {
                return o1.x > o2.x ? 1 : -1;
            }
        };
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                double dict = dis(points[i], points[j]); // 距离
                if (dict > 2 * r) {
                    continue;
                }
                double delta = Math.acos(dict / (2 * r));
                double k = Math.atan2(points[j].y - points[i].y, points[j].x - points[i].x);
                s[cnt].x = k - delta;
                s[cnt++].y = 1;
                s[cnt].x = k + delta;
                s[cnt++].y = -1;
            }
            Arrays.sort(s, 0, cnt, cmp);
            int sum = 1;
            for (int k = 0; k < cnt; k++) {
                sum += s[k].y;
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}
