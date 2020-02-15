package lsf.java._04_._447_NumberofBoomerangs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] x : points) {
            for (int[] y : points) {
                if (x != y) {
                    int d = foo(x, y);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for (int i : map.values()) {
                ans += i * (i - 1);
            }
            map.clear();
        }
        return ans;
    }

    public int foo(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBoomerangs(new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        }));
    }

}
