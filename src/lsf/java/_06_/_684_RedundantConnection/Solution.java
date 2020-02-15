package lsf.java._06_._684_RedundantConnection;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 在本问题中, 树指的是一个连通且无环的无向图。
     * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
     * 附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
     * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，
     * 满足 u < v，表示连接顶点u 和v的无向图的边。
     * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。
     * 如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int fa = father(a, map), fb = father(b, map);
            if (fa == fb) {
                return a < b ? edge : new int[]{b, a};
            } else {
                map.put(fa, fb);
            }
        }
        return null;
    }


    private int father(int child, Map<Integer, Integer> map) {
        while (map.containsKey(child)) {
            child = map.get(child);
        }
        return child;
    }

}
