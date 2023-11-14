package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task8Test {
    @Test
    void check() {
        Task8<Integer> iterator = new Task8<>(List.of(1, 2, 3));
        assertEquals(3, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(1, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}
