package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @Test
    void parseContactsTest() {
        Contacts[] contacts = new Contacts[4];
        contacts[0] = new Contacts("John Locke");
        contacts[1] = new Contacts("Thomas Aquinas");
        contacts[2] = new Contacts("David Hume");
        contacts[3] = new Contacts("Rene Descartes");
        Task5 task = new Task5();
        Contacts[] test1 = new Contacts[4];
        test1[3] = new Contacts("John Locke");
        test1[0] = new Contacts("Thomas Aquinas");
        test1[2] = new Contacts("David Hume");
        test1[1] = new Contacts("Rene Descartes");

        Contacts[] answer = task.parseContacts(contacts, "ASC");
        for (int i = 0; i < 4; i++) {
            assertEquals(test1[i].getName(), answer[i].getName());
        }
    }
}
