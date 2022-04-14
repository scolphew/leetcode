package lsf.java._07_._799_ChampagneTower;


public class Solution {

    /**
     * 把玻璃杯摆成金字塔的形状，其中第一层有 1 个玻璃杯， 第二层有 2 个，依次类推到第 100 层
     * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。
     * 当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        int max = Math.min(query_row - query_glass, query_glass) + 1; // 最宽的地方


        double[] A = new double[max];
        A[0] = poured;
        int j = 0;
        for (int i = 1; i < max; i++) {  // 1 => max-1
            j++;
            for (int k = j; k >= 0; k--) {
                A[k] = A[k] > 1 ? A[k] = (A[k] - 1) / 2 : 0;
                if (k > 0 && A[k - 1] > 1) A[k] += (A[k - 1] - 1) / 2;
            }
        }
        int end = (query_row + 1) - max;
        for (int i = max - 1; i < end; i++) { // max => (query_row+1)-max
            for (int k = j; k >= 0; k--) {
                A[k] = A[k] > 1 ? A[k] = (A[k] - 1) / 2 : 0;
                if (k > 0 && A[k - 1] > 1) A[k] += (A[k - 1] - 1) / 2;
            }
        }
        for (int i = end; i < query_row; i++) {
            for (int k = 0; k < max; k++) {
                A[k] = A[k] > 1 ? A[k] = (A[k] - 1) / 2 : 0;
                if (k < max - 1 && A[k + 1] > 1) A[k] += (A[k + 1] - 1) / 2;
            }
            max--;
        }
        return A[0] > 0 ? 1 : A[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("====" + s.champagneTower(35, 10, 5));
    }

}
