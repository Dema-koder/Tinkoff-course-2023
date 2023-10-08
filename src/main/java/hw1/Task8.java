package hw1;

public class Task8 {
    static boolean knightBoardCapture(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (i - 2 >= 0 && j - 1 >= 0 && board[i-2][j-1] == 1)
                        return false;
                    if (i - 2 >= 0 && j + 1 < board.length && board[i-2][j+1] == 1)
                        return false;
                    if (i - 1 >= 0 && j - 2 >= 0 && board[i - 1][j - 2] == 1)
                        return false;
                    if (i - 1 >= 0 && j + 2 < board.length && board[i - 1][j + 2] == 1)
                        return false;
                    if (i + 1 < board.length && j - 2 >= 0 && board[i + 1][j - 2] == 1)
                        return false;
                    if (i + 1 < board.length && j + 2 < board.length && board[i + 1][j + 2] == 1)
                        return false;
                    if (i + 2 < board.length && j - 1 >= 0 && board[i + 2][j - 1] == 1)
                        return false;
                    if (i + 2 < board.length && j + 1 < board.length && board[i + 2][j + 1] == 1)
                        return false;
                }
            }
        }
        return true;
    }
}
