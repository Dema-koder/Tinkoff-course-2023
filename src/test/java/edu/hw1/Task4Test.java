package edu.hw1;

import edu.hw1.Task4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @Test
    void fixStringTest() {
        assertEquals("214365", Task4.fixString("123456"));
    }
}
