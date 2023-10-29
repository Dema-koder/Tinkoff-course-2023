package edu.hw3;

import java.util.Comparator;

public class ContactsDescComparator implements Comparator<Contacts> {
    @Override
    public int compare(Contacts o1, Contacts o2) {
        return o1.compareTo(o2);
    }
}
