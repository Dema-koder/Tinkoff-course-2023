package edu.hw1;

@SuppressWarnings("hideutilityclassconstructor")
public class Task8 {
    private static final int[] FIRST = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] SECOND = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};

    static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int l = 0; l < board.length; l++) {
                        if (i + FIRST[l] >= 0 && i + FIRST[l] < board.length && j + SECOND[l] >= 0
                            && j + SECOND[l] < board.length) {
                            if (board[i + FIRST[l]][j + SECOND[l]] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
