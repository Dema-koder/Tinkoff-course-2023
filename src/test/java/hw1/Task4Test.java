package hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @Test
    void fixStringTest() {
        assertEquals("214365", Task4.fixString("123456"));
    }
}
