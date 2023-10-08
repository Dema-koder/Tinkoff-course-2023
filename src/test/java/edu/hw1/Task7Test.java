package edu.hw1;

import edu.hw1.Task7;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    @DisplayName("Циклический сдвиг вправо")
    void rotateRightTest() {
        assertEquals(4, Task7.rotateRight(8, 1));
    }

    @Test
    @DisplayName("Циклический сдвиг влево")
    void rotateLeftTest() {
        assertEquals(50, Task7.rotateLeft(44, 2));
    }

    @Test
    @DisplayName("Двоичная запись")
    void getBinaryTest() {
        assertEquals("1000", Task7.getBinary(8));
    }

    @Test
    void fromBinToDecTest() {
        assertEquals(13, Task7.fromBinaryToDecimal("1101"));
    }
}
