package lsf.java._07_._787_CheapestFlightsWithinKStops;

import java.util.Arrays;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1; // 不可能超过这个数
        int[] f = new int[n];
        Arrays.fill(f, INF);
        f[src] = 0;

        int ans = INF;
        for (int t = 1; t <= k + 1; t++) {
            int[] g = new int[n];
            Arrays.fill(g, INF);

            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                g[to] = Math.min(g[to], f[from] + cost);
            }
            f = g;
            ans = Math.min(ans, f[dst]);
        }
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int cheapestPrice = s.findCheapestPrice(3, new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        }, 0, 2, 1);
        System.out.println("cheapestPrice = " + cheapestPrice);
    }
}
