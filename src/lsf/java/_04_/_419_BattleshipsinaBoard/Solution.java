package lsf.java._04_._419_BattleshipsinaBoard;

public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countBattleships(new char[][]{
                "X..X".toCharArray(),
                "...X".toCharArray(),
                "..XX".toCharArray(),
        }));
    }
}
