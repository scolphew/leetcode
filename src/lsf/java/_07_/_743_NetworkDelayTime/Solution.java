package lsf.java._07_._743_NetworkDelayTime;

import java.util.*;

public class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = -1;
            }
        }

        for (int[] ints : times) {
            int f = ints[0];
            int t = ints[1];
            int l = ints[2];
            graph[f - 1][t - 1] = l;
        }
        K--;

        Map<Integer, Integer> map = new HashMap<>();

        /**
         * 优先队列，每次找里当前点最近的
         * 保证 每一轮的选择都是最短的
         */
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{K, 0});//点，距离

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int n = tmp[0];
            int toN = tmp[1];

            if (map.containsKey(n))
                continue;
            map.put(n, toN);

            for (int i = 0; i < N; i++) {
                if (graph[n][i] != -1) {
                    if (!map.containsKey(i)) {
                        q.add(new int[]{i, toN + graph[n][i]});
                    }
                }
            }
        }

        if (map.size() != N) {
            return -1;
        }
        int ans = 0;
        for (Integer value : map.values()) {
            ans = Math.max(ans, value);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.networkDelayTime(new int[][]{
                        {4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {
                        4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {
                        5, 2, 74}
                },
                5,
                3));
    }
}
