package lsf._130_SurroundedRegions;

import base.Print;

public class Solution {

    /**
     * XO组成的棋盘，把被X保卫的的O替换为X
     */
    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3)
            return;
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                foo(board, i, 0);
            if (board[i][m - 1] == 'O')
                foo(board, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O')
                foo(board, 0, i);
            if (board[n - 1][i] == 'O')
                foo(board, n - 1, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    public void foo(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            board[i][j] = '*';
            if (i > 1 && board[i - 1][j] == 'O')
                foo(board, i - 1, j);
            if (i < board.length - 2 && board[i + 1][j] == 'O')
                foo(board, i + 1, j);
            if (j > 1 && board[i][j - 1] == 'O')
                foo(board, i, j - 1);
            if (j < board[i].length - 2 && board[i][j + 1] == 'O')
                foo(board, i, j + 1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] b = new char[4][4];
        b[0] = "XOXX".toCharArray();
        b[1] = "OXOX".toCharArray();
        b[2] = "XOXO".toCharArray();
        b[3] = "OXOX".toCharArray();

        s.solve(b);
        Print.print(b);
    }
}
