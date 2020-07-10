package lsf.java._07_._746_MinCostClimbingStairs;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int i = 2;
        int a = cost[0], b = cost[1];
        while (i < cost.length) {
            int y = Math.min(a, b) + cost[i];
            a = b;
            b = y;
            i++;
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[]{10, 1, 1, 2, 3, 4, 3, 2, 4, 5, 4, 3, 2, 4, 6, 7, 3, 5, 76}));
    }

}
