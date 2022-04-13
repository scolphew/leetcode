package lsf.java._07_._782_TransformtoChessboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     一个n x n的二维网络board仅由0和1组成。每次移动，你能任意交换两列或是两行的位置。
     返回 将这个矩阵变为 “棋盘”所需的最小移动次数。如果不存在可行的变换，输出 -1。
     “棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。
     */
    public int movesToChessboard(int[][] board) {
        int N = board.length;
        Map<Integer, Integer> count = new HashMap<>(); //转成二进制
        for (int[] row : board) {
            int code = 0;
            for (int x : row)
                code = 2 * code + x;
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k1 = analyzeCount(count, N);
        if (k1 == -1) return -1;

        count = new HashMap<>();
        for (int c = 0; c < N; ++c) {
            int code = 0;
            for (int[] ints : board) code = 2 * code + ints[c];
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k2 = analyzeCount(count, N);
        return k2 >= 0 ? k1 + k2 : -1;
    }

    public int analyzeCount(Map<Integer, Integer> count, int N) {
        if (count.size() != 2) return -1;
        List<Integer> keys = new ArrayList<>(count.keySet());
        int k1 = keys.get(0), k2 = keys.get(1);
        // 数量要求，必须是N/2 和 (N+1)/2
        if (!(count.get(k1) == N / 2 && count.get(k2) == (N + 1) / 2) &&
                !(count.get(k2) == N / 2 && count.get(k1) == (N + 1) / 2))
            return -1;
        // 两个异或之后必须是 0b11111 否则不可能
        if ((k1 ^ k2) != (1 << N) - 1)
            return -1;

        int Nones = (1 << N) - 1;
        int ones = Integer.bitCount(k1 & Nones); // bitCount统计二进制中1的个数
        int cand = Integer.MAX_VALUE;
        if (N % 2 == 0 || ones * 2 < N) // 最后格式为 0101...
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);

        if (N % 2 == 0 || ones * 2 > N) // 最后格式为 1010...
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);

        return cand;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.movesToChessboard(new int[][]{{0, 1, 1, 0},{0, 1, 1, 0}, {1, 0, 0, 1}, {1, 0, 0, 1}});
        System.out.println("i = " + i);
    }
}
