package edu.hw3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void parseContactsTest() {
        Task5 task = new Task5();
        String[] test1 = new String[]{"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        ArrayList<String> ans = task.parseContacts(test1, "ASC");
        task.LOGGER.info(ans.toString());
    }
}
