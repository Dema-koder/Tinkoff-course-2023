package edu.hw3;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("hideutilityclassconstructor")
public class Task5 {
    public static final Logger LOGGER = LogManager.getLogger();

    public static Contacts[] parseContacts(Contacts[] contacts, String order) {
        for (var name : contacts) {
            LOGGER.info(name.getName());
        }
        Arrays.sort(contacts, new ContactsDescComparator());
        if (order.equals("DESC")) {
            Arrays.sort(contacts, new ContactsDescComparator().reversed());
        }
        Arrays.sort(contacts);
        return contacts;
    }
}
