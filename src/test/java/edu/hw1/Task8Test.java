package edu.hw1;

import edu.hw1.Task8;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task8Test {

    @Test
    void knightBoardCaptureTest() {
        int[][] board = new int[][] {{0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}};
        assertEquals(true, Task8.knightBoardCapture(board));
    }
}
