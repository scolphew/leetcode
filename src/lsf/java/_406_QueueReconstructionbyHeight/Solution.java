package lsf.java._406_QueueReconstructionbyHeight;

import base.Print;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * 排序  [[4,4], [5,2], [5,0], [6,1], [7,1], [7,0]]  （第一个递增，第二个递减）
     * 然后,一次插入到对应位置(p[a,b]插入到都b个空位置)
     * (1)[4,4], index = 4,--> [][][][][4,4][]
     * (2)[5,2], index = 2 --> [][][5,2][][4,4][]
     * (3)[5,0], index = 0, --> [5,0][][5,2][][4,4][]
     * (4)[6,1], index = 1, --> [5,0][][5,2][6,1][4,4][]
     * (5)[7,1], index = 1, ->[5,0][][5,2][6,1][4,4][7,1]
     * (5)[7,0], index = 0, -->[5,0][7,0][5,2][6,1][4,4][7,1]
     *
     * @param people
     * @return
     */

    public int[][] reconstructQueue(int[][] people) {
        if (people.length < 2)
            return people;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int[][] ans = new int[people.length][2];
        for (int[] a : ans)
            a[1] = -1;

        for (int[] p : people) {
            insert(ans, p);
        }
        return ans;
    }

    private void insert(int[][] ans, int[] p) {
        int index = p[1];
        for (int i = 0; i < ans.length; i++) {
            if (ans[i][1] == -1)
                index--;
            if (index < 0) {
                ans[i] = p;
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = {{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {0, 0}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}};
        ints = new Solution().reconstructQueue(ints);
        Print.print(ints);
    }
}
