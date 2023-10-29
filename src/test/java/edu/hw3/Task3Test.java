package edu.hw3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void freqDictTest() {
        Task3 task = new Task3();

        Map<String, Integer> firstTest = new HashMap<>();
        firstTest.put("bb", 2);
        firstTest.put("a", 2);

        Map<String, Integer> secondTest = new HashMap<>();
        secondTest.put("that", 1);
        secondTest.put("and", 2);
        secondTest.put("this", 1);

        Map<String, Integer> thirdTest = new HashMap<>();
        thirdTest.put("код", 3);
        thirdTest.put("bug", 1);

        Map<Integer, Integer> fourthTest = new HashMap<>();
        fourthTest.put(1, 2);
        fourthTest.put(2, 2);

        assertEquals(firstTest, task.freqDict(new String[] {"a", "bb", "a", "bb"}));
        assertEquals(secondTest, task.freqDict(new String[] {"this", "and", "that", "and"}));
        assertEquals(thirdTest, task.freqDict(new String[] {"код", "код", "код", "bug"}));
        assertEquals(fourthTest, task.freqDict(new Integer[] {1, 1, 2, 2}));
    }
}
