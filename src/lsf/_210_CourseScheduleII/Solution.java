package lsf._210_CourseScheduleII;

import java.util.*;

public class Solution {
    /**
     * 拓扑排序,超时
     *
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];   //  b->a
            graph.get(b).add(a);
        }

        int n = numCourses;
        int index = numCourses - 1;
        out:
        while (n-- > 0) {
            for (int i : graph.keySet()) {
                if (graph.get(i).size() == 0) {
                    res[index--] = i;
                    graph.remove(i);
                    for (int j : graph.keySet()) {
                        if (graph.get(j).contains(i)) {
                            graph.get(j).remove(i);
                        }
                    }
                    continue out;
                }
            }
            return new int[0];
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().findOrder(4, new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
        });
    }
}
