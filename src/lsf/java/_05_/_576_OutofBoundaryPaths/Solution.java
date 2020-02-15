package lsf.java._05_._576_OutofBoundaryPaths;

import java.util.Arrays;

public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        int[][] temp = new int[m][n];
        count[i][j] = 1;
        int result = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            for (int[] ints : temp) {
                Arrays.fill(ints, 0);
            }
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (count[r][c] != 0) {
                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                result = (result + count[r][c]) % MOD;
                            } else {
                                temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                            }
                        }
                    }
                }
            }
            int[][] x = count;
            count = temp;
            temp = x;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPaths(1, 3, 3, 0, 1));
    }

}
