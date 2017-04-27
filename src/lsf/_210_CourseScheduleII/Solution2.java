package lsf._210_CourseScheduleII;

import java.util.*;


/**
 * 深度优先 拓扑排序
 */
public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];// 表示入读的大小
        List<List<Integer>> adjs = new ArrayList<>(numCourses);//表示图
        initialiseGraph(incLinkCounts, adjs, prerequisites);// 初始化
        return solveByBFS(incLinkCounts, adjs);
        //return solveByDFS(adjs);

    }

    /**
     * 初始化
     *
     * @param incLinkCounts
     * @param adjs
     * @param prerequisites
     */
    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
        int n = incLinkCounts.length;
        while (n-- > 0)
            adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    /**
     * 广度优先
     *
     * @param incLinkCounts 入度
     * @param adjs
     * @return
     */
    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs) {
        int[] order = new int[incLinkCounts.length];  //结果
        Queue<Integer> toVisit = new ArrayDeque<>();  //访问队列
        for (int i = 0; i < incLinkCounts.length; i++) {//初始入度为0的点入栈
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        //如果之访问点不是全部，说明剩下的点形成环
        return visited == incLinkCounts.length ? order : new int[0];
    }


    /**
     * 深度优先
     *
     * @param adjs
     * @return
     */
    private int[] solveByDFS(List<List<Integer>> adjs) {
        BitSet visited = new BitSet(adjs.size());
        BitSet onStack = new BitSet(adjs.size());
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = adjs.size() - 1; i >= 0; i--) {//对于每个点
            if (!visited.get(i) && !hasOrder(i, adjs, visited, onStack, order))
                return new int[0];
        }
        int[] orderArray = new int[adjs.size()];
        for (int i = 0; !order.isEmpty(); i++) orderArray[i] = order.pop();
        return orderArray;
    }

    private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
        visited.set(from);
        onStack.set(from);
        for (int to : adjs.get(from)) {
            if (!visited.get(to)) {
                if (!hasOrder(to, adjs, visited, onStack, order))
                    return false;
            } else if (onStack.get(to)) {
                return false;
            }
        }
        onStack.clear(from);
        order.push(from);
        return true;
    }

    public static void main(String[] args) {
        new Solution2().findOrder(4, new int[][]{
                {1, 0},
                {0, 1},
                //{3, 1},
                //{3, 2},
        });
    }

}
