package lsf.java._07_._794_ValidTicTacToeState;

public class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        int row = 0, col = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                } else if (c == 'O') {
                    oCount++;
                }
            }
        }
        // 数量错误
        if (xCount != oCount && xCount - 1 != oCount) return false;
        // 后手不能赢
        if (xCount - 1 == oCount) return !win(board, 'O');
        // 先手不能赢
        return !win(board, 'X');
    }

    public boolean win(String[] board, char p) {
        for (int i = 0; i < 3; ++i) {
            if ((p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i))
                    || (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2))) {
                return true;
            }
        }
        return ((p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2))
                || (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)));
    }
}
