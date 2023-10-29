package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    void clusterizeTest() {
        Task2 task = new Task2();
        ArrayList<String>firstTest = new ArrayList<>();
        firstTest.add("()");
        firstTest.add("()");
        firstTest.add("()");

        ArrayList<String>secondTest = new ArrayList<>();
        secondTest.add("((()))");

        ArrayList<String>thirdTest = new ArrayList<>();
        thirdTest.add("((()))");
        thirdTest.add("(())");
        thirdTest.add("()");
        thirdTest.add("()");
        thirdTest.add("(()())");

        try {
            assertEquals(firstTest, task.clusterize("()()()"));
        } catch (Task2.IncorrectStringException e) {
            assertThrows(Task2.IncorrectStringException.class, () -> {task.clusterize("()()()");});
        }
        try {
            assertEquals(secondTest, task.clusterize("((()))"));
        } catch (Task2.IncorrectStringException e) {
            assertThrows(Task2.IncorrectStringException.class, () -> {task.clusterize("((()))");});
        }
        try {
            assertEquals(thirdTest, task.clusterize("((()))(())()()(()()a"));
        } catch (Exception e) {
            assertThrows(Task2.IncorrectStringException.class, () -> {task.clusterize("((()))(())()()(()()a");});
        }
    }
}
