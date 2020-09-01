package lsf.java._07_._778_SwiminRisingWater;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a / N][a % N]));
        Set<Integer> canTo = new HashSet<>();

        pq.add(0);
        canTo.add(0);

        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int t = pq.poll();
            int x = t / N, y = t % N;
            ans = Math.max(ans, grid[x][y]);


            if (t == (N * N - 1)) {
                return ans;
            }


            for (int[] ints : d) {
                int xs = ints[0] + x;
                int ys = ints[1] + y;
                int xy = xs * N + ys;

                if (xs >= 0 && xs < N && ys >= 0 & ys < N && !canTo.contains(xy)) {
                    pq.offer(xy);
                    canTo.add(xy);
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.swimInWater(
                new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}
        ));
    }

}
