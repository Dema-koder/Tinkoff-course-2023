package edu.hw1;

@SuppressWarnings({"hideutilityclassconstructor", "magicnumber"})
public class Task8 {
    static boolean knightBoardCapture(int[][] board) {
        int[] first = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] second = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int l = 0; l < 8; l++) {
                        if (i + first[l] >= 0 && i + first[l] < board.length && j + second[l] >= 0
                            && j + second[l] < board.length) {
                            if (board[i + first[l]][j + second[l]] == 1) {
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
