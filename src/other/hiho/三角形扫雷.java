package other.hiho;

import java.util.Scanner;

public class 三角形扫雷 {


    /**
     * 小Hi在设计一款新的扫雷游戏。与传统扫雷不同，这款扫雷游戏是在三角形网格中进行的。
     * 下图是一个N=4的扫雷游戏地图，其中每一个最小的单位三角形中可能有雷(包含星号)或者无雷。
     * 给出一个扫雷游戏的地图，请你对于所有无雷的单位三角形，计算其周围相邻的单位三角形中有多少是有雷的。
     * 两个单位三角形相邻当且仅当它们有一条公共边。
     * 输入
     * 第一行包含一个整数N，代表地图的大小。
     * 以下N行，第i行包含2i-1个字符，代表地图中每个单位三角形是否有雷。其中星号代表有雷，点代表无雷。
     * 1 <= N <= 100
     * 输出
     * 使用与输入相同的格式输出地图。并将输入中的点(无雷的三角形)替换成一个整数，代表它周围相邻的有雷三角形数目。
     * 样例输入
     * 4
     * *
     * ...
     * .*.*.
     * ...**..
     * 样例输出
     * *
     * 111
     * 1*3*1
     * 001**10
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        if (n == 1) {
            // 只有一个
            char c = in.next().charAt(0);
            System.out.println((c == '*') ? '*' : 0);
        }

        char[][] board = new char[n + 1][2 * n + 1];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = n - i, k = 0; k < 2 * i + 1; j++, k++) {
                board[i][j] = s.charAt(k);
            }
        }
        for (int i = 0; i < n; i++) {
            int flag = 1;
            for (int j = n - i, k = 0; k < 2 * i + 1; j++, k++) {
                char c = board[i][j] == '*' ? '*' : (char) ('0' + ((board[i][j + 1] == '*' ? 1 : 0) + (board[i][j - 1] == '*' ? 1 : 0) + (board[i + flag][j] == '*' ? 1 : 0)));
                System.out.print(c);
                flag = -flag;
            }
            System.out.println();
        }


        //for (int i = 0; i < board.length; i++) {
        //    for (int j = 0; j < board[0].length; j++) {
        //        System.out.print(board[i][j] == 0 ? '_' : board[i][j]);
        //    }
        //    System.out.println();
        //}
    }

}
