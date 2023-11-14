package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    void firstTest() {
        Task2 task = new Task2();
        ArrayList<String>firstTest = new ArrayList<>();
        firstTest.add("()");
        firstTest.add("()");
        firstTest.add("()");

        try {
            assertEquals(firstTest, task.clusterize("()()()"));
        } catch (Task2.IncorrectStringException e) {
            assertThrows(Task2.IncorrectStringException.class, () -> {task.clusterize("()()()");});
        }
    }

    @Test
    void secondTest() {
        Task2 task = new Task2();
        ArrayList<String>secondTest = new ArrayList<>();
        secondTest.add("((()))");

        try {
            assertEquals(secondTest, task.clusterize("((()))"));
        } catch (Task2.IncorrectStringException e) {
            assertThrows(Task2.IncorrectStringException.class, () -> {task.clusterize("((()))");});
        }
    }

    @Test
    void thirdTest() {
        Task2 task = new Task2();
        ArrayList<String>thirdTest = new ArrayList<>();
        thirdTest.add("((()))");
        thirdTest.add("(())");
        thirdTest.add("()");
        thirdTest.add("()");
        thirdTest.add("(()())");

        try {
            assertEquals(thirdTest, task.clusterize("((()))(())()()(()()a"));
        } catch (Exception e) {
            assertThrows(Task2.IncorrectStringException.class, () -> {task.clusterize("((()))(())()()(()()a");});
        }
    }
}
