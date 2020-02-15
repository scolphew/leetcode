package lsf.java._05_._529_Minesweeper;


import base.Print;

public class Solution {

    private static int m;
    private static int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        n = board.length;
        m = board[0].length;
        return updateBoard(board, click[0], click[1]);
    }


    public char[][] updateBoard(char[][] board, int a, int b) {
        if (board[a][b] == 'M') {
            board[a][b] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    int x = a + i;
                    int y = b + j;
                    if (x < 0 || x >= n || y < 0 || y >= m)
                        continue;
                    if (board[x][y] == 'M' || board[x][y] == 'X')
                        count++;
                }
            }
            if (count > 0) {
                board[a][b] = (char) (count + '0');
            } else {
                board[a][b] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0)
                            continue;
                        int x = a + i;
                        int y = b + j;
                        if (x < 0 || x >= n || y < 0 || y >= m)
                            continue;
                        if (board[x][y] == 'E')
                            updateBoard(board, x, y);
                    }
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] chars = s.updateBoard(new char[][]{
                "EEEEE".toCharArray(),
                "EEMEE".toCharArray(),
                "EEEEE".toCharArray(),
                "EEEEE".toCharArray(),
        }, new int[]{3, 0});
        Print.print(chars);
    }

}
