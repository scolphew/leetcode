package lsf.java._363_MaxSumofRectangleNoLargerThanK;

import java.util.TreeSet;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] array = new int[n];
            for (int j = i; j >= 0; j--) {
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                for (int k = 0; k < n; k++) {
                    array[k] = array[k] + matrix[j][k];
                    val = val + array[k];
                    Integer subres = set.ceiling(val - target);
                    if (null != subres) {
                        res = Math.max(res, val - subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{
                {1, 0, 1},
                {0, -2, 3}
        }, 2));
    }
}
