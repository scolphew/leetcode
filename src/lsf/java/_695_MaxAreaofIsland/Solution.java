package lsf.java._695_MaxAreaofIsland;

import java.util.Stack;

public class Solution {


    /**
     * 最大的岛
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean flag[][] = new boolean[m][n];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((grid[i][j] == 0) || flag[i][i])
                    continue;

                int area = 0;
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});
                flag[i][j] = true;
                while (!stack.isEmpty()) {
                    area++;
                    int[] tmp = stack.pop();
                    int x = tmp[0], y = tmp[1];

                    for (int k = 0; k < 4; k++) {
                        int x1 = x + dx[k];
                        int y1 = y + dy[k];
                        if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == 1 && !flag[x1][y1]) {
                            stack.push(new int[]{x1, y1});
                            flag[x1][y1] = true;
                        }
                    }
                }
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int x = s.maxAreaOfIsland(
                new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }
        );
        System.out.println(x);
    }
}
